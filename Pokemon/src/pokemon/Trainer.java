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
    Monster[] monsters;
    int currentMonster=0;
    public Trainer(Monster[] m) {
        this.monsters = m;
    }
    public Monster currentMonster() {
        return this.monsters[this.currentMonster];
    }
}
