document.addEventListener("DOMContentLoaded", function () {
    var body = document.body;
    var transitionDuration = 680;

    window.requestAnimationFrame(function () {
        body.classList.add("is-loaded");
    });

    var authCards = document.querySelectorAll(".js-auth-card");
    authCards.forEach(function (card) {
        card.addEventListener("mousemove", function (e) {
            var rect = card.getBoundingClientRect();
            var x = e.clientX - rect.left;
            var y = e.clientY - rect.top;

            card.style.setProperty("--mouse-x", x + "px");
            card.style.setProperty("--mouse-y", y + "px");
        });

        card.addEventListener("mouseleave", function () {
            card.style.setProperty("--mouse-x", "50%");
            card.style.setProperty("--mouse-y", "50%");
        });
    });

    var toggleButtons = document.querySelectorAll(".js-password-toggle");
    toggleButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            var targetId = button.getAttribute("data-target");
            var input = document.getElementById(targetId);

            if (!input) {
                return;
            }

            var isPassword = input.getAttribute("type") === "password";
            input.setAttribute("type", isPassword ? "text" : "password");
            button.classList.toggle("is-active", isPassword);
            button.setAttribute("aria-label", isPassword ? "Ocultar contraseña" : "Mostrar contraseña");
        });
    });

    var navLinks = document.querySelectorAll(".js-auth-nav");
    navLinks.forEach(function (link) {
        link.addEventListener("click", function (e) {
            if (
                e.defaultPrevented ||
                e.button !== 0 ||
                e.metaKey ||
                e.ctrlKey ||
                e.shiftKey ||
                e.altKey
            ) {
                return;
            }

            var href = link.getAttribute("href");
            var target = link.getAttribute("target");

            if (!href || href.charAt(0) === "#" || target === "_blank") {
                return;
            }

            e.preventDefault();

            if (body.classList.contains("is-transitioning")) {
                return;
            }

            body.classList.remove("is-loaded");
            body.classList.add("is-transitioning");

            window.setTimeout(function () {
                window.location.href = link.href;
            }, transitionDuration);
        });
    });
});