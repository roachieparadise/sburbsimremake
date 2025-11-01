document.addEventListener('DOMContentLoaded', function() {
    function random(arr) {
        return arr[Math.floor(Math.random() * arr.length)];
    }
    
    function generateName() {
        const randomName = random(GameData.humanFirstNames);
        const randomSurname = random(GameData.humanLastNames);
        return `${randomName} ${randomSurname}`;
    }
    
    function generateHandle() {
        const randomPrefix = random(GameData.chumHandlePrefixes);
        const randomSuffix = random(GameData.chumHandleSuffixes);
        return `${randomPrefix}${randomSuffix}`;
    }
    
    function generateLand() {
        const noun1 = random(GameData.landNouns);
        const noun2 = random(GameData.landNouns.filter(n => n !== noun1));
        const denizen = random(GameData.denizens);
        const fullName = `Land of ${noun1} and ${noun2}`;
        return `${fullName} and its denizen is ${denizen}`;
    }
    
    function generatePlayer() {
        const player = {
            name: generateName(),
            color: null,
            aspect: null,
            class: null,
            classpect: "",
            chumHandle: generateHandle(),
            land: generateLand(),
            specibus: random(GameData.specibus)
        };
        
        const aspectData = random(GameData.aspects);
        player.aspect = aspectData.name;
        player.color = aspectData.color;
        
        const classData = random(GameData.classes);
        player.class = classData.name;
        player.classpect = `${player.class} of ${player.aspect}`;
        
        return player;
    }

    const playerCount = 4 + Math.floor(Math.random() * 9); // Random number from 4 to 12
    const players = [];
    
    for (let i = 0; i < playerCount; i++) {
        players.push(generatePlayer());
    }

var demoElement = document.getElementById("demo");
    

    let html = `
        <style>
            .player-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 15px;
                padding: 10px;
            }
            .player-card {
                padding: 15px;
                border-left: 4px solid;
                background-color: #1a1a1a;
                border-radius: 4px;
            }
            .player-card strong {
                font-size: 1.1em;
            }
            .player-card div {
                margin: 5px 0;
                font-size: 0.9em;
            }
        </style>
        <h2>Session has ${playerCount} players:</h2>
        <div class="player-grid">
    `;
    
    players.forEach((player, index) => {
        html += `
            <div class="player-card" style="border-left-color: ${player.color}; color: ${player.color};">
                <strong>${player.name}</strong>
                <div><em>${player.chumHandle}</em></div>
                <div>${player.classpect}</div>
                <div style="font-size: 0.85em; opacity: 0.8;">${player.land}</div>
                <div style="font-size: 0.85em;">${player.specibus}</div>
            </div>
        `;
    });
    
    html += `</div>`;
    
    demoElement.innerHTML = html;
});