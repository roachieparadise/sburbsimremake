package com.main.java.modelss;

import java.util.*;

public class GameSession {
    private String sessionId;
    private List<Player> players;
    private AdventureState state;
    private int currentPlayerIndex; 
    
    public GameSession() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }
    
    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
    public Player getCurrentPlayer() { return players.get(currentPlayerIndex); }
}