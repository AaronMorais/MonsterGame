/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Matt
 */
public class Trainer {
    //assign attributes to the Trainer class
    String name;
    Monster[] monsters;
    int currentMonsterIndex = 0;
    //Trainer constructor
    public Trainer(String name, Monster[] monsters) {
        //assign the Trainer's name to the name in the constructor
        this.name = name;
        //assign the Trainer's monsters to the array given
        this.monsters = monsters;
    }
    //Output the current monster in the array of monsters
    public Monster currentMonster() {
        return this.monsters[this.currentMonsterIndex];
    }
}
