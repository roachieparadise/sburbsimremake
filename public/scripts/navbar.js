function createNavbar() {
    const container = document.getElementById('navbar');
    if (!container) {
        console.warn('createNavbar: #navbar element not found');
        return;
    }

    container.innerHTML =  `<nav class="navbar navbar-expand-lg navbar-light bg-light border border-green-5">
        <div class="container justify-content-center">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                <ul class="navbar-nav mx-auto text-center">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Sessions
                        </a>
                        <ul class="dropdown-menu dropdown-menu-center" style="left: 50%; transform: translateX(-50%);">
                            <li><a class="dropdown-item" data-page="sessions" href="#" onclick="loadContent('sessions')">New Session</a></li>
                            <li><a class="dropdown-item" href="#">WIP</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-page="about" href="#" onclick="loadContent('about')">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-page="about" href="#" onclick="loadContent('credits')">Credits</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>`;

}