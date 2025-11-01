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
      return `${randomPrefix}${randomSuffix}`
    }

    function generateLand() {
      const noun1 = random(GameData.landNouns);
      const noun2 = random(GameData.landNouns.filter(n => n !== noun1));
      const denizen = random(GameData.denizens);
      const fullName = `Land of ${noun1} and ${noun2}`;

      return `${fullName} and its denizen is ${denizen}`
    }

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

const classData = random(GameData.classes)
player.class = classData.name

player.classpect = `${player.class} of ${player.aspect}`;

    
    var demoElement = document.getElementById("demo");
    demoElement.innerHTML = `<div style="color:${player.color}">
      ${player.name}<br>
      ${player.aspect}<br>
      ${player.class}<br>
      ${player.classpect}<br>
      ${player.chumHandle}<br>
      ${player.land}<br>
      ${player.specibus}
    </div>`;
});