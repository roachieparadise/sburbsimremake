function createContent() {
    const container = document.getElementById('content');
    if (!container) {
        console.warn('it didnt WORK');
        return;
    }
    container.innerHTML = `<p>testing this</p>`;
}