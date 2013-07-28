/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Matt
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monster[] humanMonsters = new Monster[]{new Monster("pikachu"), new Monster("pikachu"), new Monster("pikachu")};
        Trainer human = new Trainer(humanMonsters);
        Monster[] computerMonsters = new Monster[]{new Monster("pikachu"), new Monster("pikachu"), new Monster("pikachu")};
        Trainer computer = new Trainer(computerMonsters);
        Fight fight = new Fight(human, computer);
        fight.start();
    }
}
