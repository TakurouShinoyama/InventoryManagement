document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.querySelector('.menu-toggle');
    const mainNavigation = document.querySelector('.main-navigation');
    const mainHeader = document.querySelector('.main-header');
    const headerSpacer = document.querySelector('.header-spacer');

    // ハンバーガーメニューのトグル機能
    menuToggle.addEventListener('click', function() {
        // メニューの開閉状態を切り替える
        this.classList.toggle('is-active');
        mainNavigation.classList.toggle('is-active');

        // アクセシビリティのためaria-expanded属性を切り替える
        const isExpanded = this.classList.contains('is-active');
        this.setAttribute('aria-expanded', isExpanded);

        // メニューが開いたときにbodyのスクロールを固定 (任意)
        // document.body.style.overflow = isExpanded ? 'hidden' : '';
    });

    // ヘッダーの高さ分のスペーサーを設定する関数
    function setHeaderSpacerHeight() {
        const headerHeight = mainHeader.offsetHeight; // ヘッダーの現在の高さを取得
        headerSpacer.style.height = headerHeight + 'px'; // スペーサーの高さを設定
    }

    // ページロード時とウィンドウのリサイズ時にスペーサーの高さを設定
    setHeaderSpacerHeight(); // 初期ロード時
    window.addEventListener('resize', setHeaderSpacerHeight); // ウィンドウリサイズ時

    // (オプション) メニュー項目をクリックしたらメニューを閉じる
    mainNavigation.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', function() {
            if (mainNavigation.classList.contains('is-active')) {
                menuToggle.classList.remove('is-active');
                mainNavigation.classList.remove('is-active');
                menuToggle.setAttribute('aria-expanded', 'false');
                // document.body.style.overflow = ''; // スクロール固定を解除
            }
        });
    });
});