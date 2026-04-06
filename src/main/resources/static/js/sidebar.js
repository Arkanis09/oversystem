document.addEventListener("DOMContentLoaded", function () {
    const body = document.body;
    const sidebar = document.getElementById("appSidebar");
    const overlay = document.getElementById("sidebarOverlay");
    const toggleButton = document.getElementById("sidebarToggle");
    const closeButton = document.getElementById("sidebarClose");

    const desktopMedia = window.matchMedia("(min-width: 992px)");
    const STORAGE_KEY = "oversystem.sidebar.desktop.state";

    if (!sidebar || !overlay || !toggleButton || !closeButton) {
        return;
    }

    function isDesktop() {
        return desktopMedia.matches;
    }

    function clearDesktopClasses() {
        body.classList.remove("sidebar-expanded", "sidebar-collapsed", "sidebar-hidden");
        sidebar.classList.remove("is-collapsed", "is-hidden");
    }

    function closeMobileSidebar() {
        body.classList.remove("sidebar-mobile-open");
        sidebar.classList.remove("mobile-open");
        overlay.classList.remove("show");
    }

    function openMobileSidebar() {
        body.classList.add("sidebar-mobile-open");
        sidebar.classList.remove("is-collapsed", "is-hidden");
        sidebar.classList.add("mobile-open");
        overlay.classList.add("show");
    }

    function setExpandedDesktop(saveState) {
        clearDesktopClasses();
        closeMobileSidebar();

        body.classList.add("sidebar-expanded");

        if (saveState !== false) {
            localStorage.setItem(STORAGE_KEY, "expanded");
        }
    }

    function setCollapsedDesktop(saveState) {
        clearDesktopClasses();
        closeMobileSidebar();

        body.classList.add("sidebar-collapsed");
        sidebar.classList.add("is-collapsed");

        if (saveState !== false) {
            localStorage.setItem(STORAGE_KEY, "collapsed");
        }
    }

    function setHiddenDesktop(saveState) {
        clearDesktopClasses();
        closeMobileSidebar();

        body.classList.add("sidebar-hidden");
        sidebar.classList.add("is-hidden");

        if (saveState !== false) {
            localStorage.setItem(STORAGE_KEY, "hidden");
        }
    }

    function applyInitialState() {
        if (isDesktop()) {
            const savedState = localStorage.getItem(STORAGE_KEY);

            if (savedState === "collapsed") {
                setCollapsedDesktop(false);
            } else if (savedState === "hidden") {
                setHiddenDesktop(false);
            } else {
                setExpandedDesktop(false);
            }
        } else {
            clearDesktopClasses();
            closeMobileSidebar();
        }
    }

    toggleButton.addEventListener("click", function () {
        if (isDesktop()) {
            if (body.classList.contains("sidebar-hidden")) {
                setExpandedDesktop();
                return;
            }

            if (body.classList.contains("sidebar-collapsed")) {
                setExpandedDesktop();
                return;
            }

            setCollapsedDesktop();
            return;
        }

        if (sidebar.classList.contains("mobile-open")) {
            closeMobileSidebar();
        } else {
            openMobileSidebar();
        }
    });

    closeButton.addEventListener("click", function () {
        if (isDesktop()) {
            setHiddenDesktop();
        } else {
            closeMobileSidebar();
        }
    });

    overlay.addEventListener("click", function () {
        closeMobileSidebar();
    });

    document.addEventListener("keydown", function (event) {
        if (event.key !== "Escape") {
            return;
        }

        if (isDesktop()) {
            if (!body.classList.contains("sidebar-hidden")) {
                setHiddenDesktop();
            }
        } else {
            closeMobileSidebar();
        }
    });

    if (typeof desktopMedia.addEventListener === "function") {
        desktopMedia.addEventListener("change", applyInitialState);
    } else if (typeof desktopMedia.addListener === "function") {
        desktopMedia.addListener(applyInitialState);
    }

    applyInitialState();
});