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
    String name;
    Monster[] monsters;
    int currentMonsterIndex = 0;
    public Trainer(String name, Monster[] monsters) {
        this.name = name;
        this.monsters = monsters;
    }
    public Monster currentMonster() {
        return this.monsters[this.currentMonsterIndex];
    }
}
