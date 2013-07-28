/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Matt
 */

public class Monster {
    public enum MonsterType {
        WATER, FIRE, GRASS, ELECTRIC, GROUND, FLYING
    }
    public Monster(String monsterName) {
        if(monsterName.equals("pikachu")) {
            this.type = MonsterType.ELECTRIC;
            this.attack = 50;
            this.defense = 30;
            this.speed = 100;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Thundershock", "Thunderbolt", "Thunderpunch", "Thunder"};
            this.name = monsterName;            
        }
    }
    MonsterType type;
    int hp = 100; 
    int attack;
    int defense;
    int speed;
    String[] moveNames;
    int[] moves;
    String name;    
}
