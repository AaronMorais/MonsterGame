/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Matt
 */
public class Fight {
    public Fight(Trainer human, Trainer computer) {
        this.human = human;
        this.computer = computer;
    }
    Trainer human;
    Trainer computer;
    
    public void start() {
        printStatus();
    }
    public void printStatus() {
        Monster computerMonster = computer.currentMonster();
        System.out.println(computerMonster.name);
        System.out.println("HP: " + computerMonster.hp );
        System.out.println("vs.");
        Monster humanMonster = human.currentMonster();
        System.out.println(humanMonster.name);
        System.out.println("HP: " + humanMonster.hp);
        System.out.println("Moves: ");
        for(int i=0; i<humanMonster.moves.length; i++) {
            System.out.println(i+1 + "- " + humanMonster.moveNames[i]);
        }
    }
}
