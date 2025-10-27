async function loadContent(page) {
    try {
        const response = await fetch(`pages/${page}.html`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const content = await response.text();
        document.getElementById('content').innerHTML = content;
        

        document.querySelectorAll('.nav-link').forEach(link => {
            link.classList.remove('active');
            if (link.getAttribute('data-page') === page) {
                link.classList.add('active');
            }
        });


        history.pushState({ page: page }, '', `#${page}`);
    } catch (error) {
        console.error('Error loading content:', error);
        document.getElementById('content').innerHTML = '<div class="alert alert-danger">Error loading content</div>';
    }
}

// Handle browser back/forward buttons
window.addEventListener('popstate', function(event) {
    if (event.state && event.state.page) {
        loadContent(event.state.page);
    }
});

// Load initial content based on URL hash or default to about
document.addEventListener('DOMContentLoaded', function() {
    const initialPage = window.location.hash.slice(1) || 'about';
    loadContent(initialPage);
});