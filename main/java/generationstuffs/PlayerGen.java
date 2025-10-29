package com.main.java.generationstuffs;

import java.modelss.*;
import java.sservice.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PlayerGenerator {
    
    @Autowired
    private DataLoader dataLoader;
    
    private Random random = new Random();
    
    public List<Player> generatePlayers() {
        int playerCount = 4 + random.nextInt(9); // generates 4 to 12 playurs
        
        List<Player> players = new ArrayList<>();
        Set<String> usedNames = new HashSet<>();
        Set<String> usedHandles = new HashSet<>();
        
        for (int i = 0; i < playerCount; i++) {
            Player player = generateUniquePlayer(usedNames, usedHandles);
            players.add(player);
        }
        
        return players;
    }
    
    private Player generateUniquePlayer(Set<String> usedNames, Set<String> usedHandles) {
        String name;
        do {
            name = generateName();
        } while (usedNames.contains(name));
        usedNames.add(name);
        
        String chumHandle;
        do {
            chumHandle = generateChumHandle();
        } while (usedHandles.contains(chumHandle));
        usedHandles.add(chumHandle);
        
        Player player = new Player();
        player.setName(name);
        player.setChumHandle(chumHandle);

        Map<String, Object> playerSpecies = randomFromList(dataLoader.getSpecies());
        player.setSpecies((String) playerSpecies.get("name"));
        
        Map<String, Object> aspect = randomFromList(dataLoader.getAspects());
        player.setAspect((String) aspect.get("name"));
        player.setAspectColor((String) aspect.get("color"));
        
        Map<String, Object> playerClass = randomFromList(dataLoader.getClasses());
        player.setPlayerClass((String) playerClass.get("name"));
        
        player.setClasspect(player.getPlayerClass() + " of " + player.getAspect());
        player.setColor((String) aspect.get("color"));
        player.setSpecibus(randomFromList(dataLoader.getSpecibus()));
        player.setGrist(0);
        player.setRungLevel(0);
        
        return player;
    }
    
    private String generateName() {
        if (speciesIsTroll()) {
            String firstName = randomFromList(dataLoader.getTrollNames());
            String lastName = randomFromList(dataLoader.getTrollSur());
            return firstName + " " + lastName;
        } else {
            String firstName = randomFromList(dataLoader.getHumanNames());
            String lastName = randomFromList(dataLoader.getHumanLast());
            return firstName + " " + lastName;
        }
    }
    
    private String generateChumHandle() {
        String prefix = randomFromList(dataLoader.getChumHandlePrefixes());
        String suffix = randomFromList(dataLoader.getChumHandleSuffixes());
        return prefix + suffix;
    }
    
    private <T> T randomFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}