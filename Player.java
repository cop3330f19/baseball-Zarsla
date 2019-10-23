/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;



/**
 *
 * This class stores the data read from the file
 * 
 * @author Marisa Ibraheem
 */
public class Player  {
    
    private String name;
    private String team;
    private float atBats;
    private float hits;

    //default constructor
    public Player() {
        this.name = "";
        this.team = "";
        this.atBats = 0.0;
        this.hits = 0.0;
    }

    /**
     * Overloaded constructor
     * 
     * @param name
     * @param team
     * @param atBats
     * @param hits 
     */
    public Player(String name, String team, float atBats, float hits) {
        this.name = name;
        this.team = team;
        this.atBats = atBats;
        this.hits = hits;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public float getAtBats() {
        return atBats;
    }

    public void setAtBats(String atBats) {
        this.atBats = atBats;
    }

    public float getHits() {
        return atBats;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }   
    
    public float getAverage() {
        return this.getHits()/this.getAtBats();
    }    
    
}
