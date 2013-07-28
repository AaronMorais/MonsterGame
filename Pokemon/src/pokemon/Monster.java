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
        if(monsterName.equals("Pikachu")) {
            this.type = MonsterType.ELECTRIC;
            this.attack = 50;
            this.defense = 30;
            this.speed = 100;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Thundershock", "Thunderbolt", "Thunderpunch", "Thunder"};
            this.name = monsterName;            
        } else if(monsterName.equals("Charmander")) {
            this.type = MonsterType.FIRE;
            this.attack = 40;
            this.defense = 40;
            this.speed = 80;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Ember", "Flame Wheel", "Flamethrower", "Fire Blast"};
            this.name = monsterName; 
        } else if(monsterName.equals("Squirtle")) {
            this.type = MonsterType.WATER;
            this.attack = 30;
            this.defense = 50;
            this.speed = 70;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Water Gun", "Water Pulse", "Surf", "Hydro Pump"};
            this.name = monsterName; 
        } else if(monsterName.equals("Bulbasaur")) {
            this.type = MonsterType.GRASS;
            this.attack = 60;
            this.defense = 30;
            this.speed = 50;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Tackle", "Vine Whip", "Razor Leaf", "Solarbeam"};
            this.name = monsterName; 
        } else if(monsterName.equals("Geodude")) {
            this.type = MonsterType.GROUND;
            this.attack = 40;
            this.defense = 70;
            this.speed = 50;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Rock Throw", "Magnitude", "Rock Smash", "Earthquake"};
            this.name = monsterName; 
        }else if(monsterName.equals("Pidgey")) {
            this.type = MonsterType.FLYING;
            this.attack = 40;
            this.defense = 30;
            this.speed = 120;
            this.moves = new int[]{-10, -30, -40, -60};
            this.moveNames = new String[]{"Gust", "Wing Attack", "Aerial Ace", "Brave Bird"};
            this.name = monsterName; 
        }
    }
    MonsterType type;
    int hp = 100; 
    double attack;
    double defense;
    int speed;
    String[] moveNames;
    int[] moves;
    String name;    
}
