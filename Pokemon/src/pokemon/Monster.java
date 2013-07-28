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
    
    MonsterType type;
    int hp; 
    int level;
    int attack;
    int defense;
    int speed;   
    int[] moves;
           
}
