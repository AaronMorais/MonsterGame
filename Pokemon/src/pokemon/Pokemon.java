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
        Monster[] humanMonsters = new Monster[]{new Monster("Charmander"), new Monster("Squirtle"), new Monster("Pikachu")};
        Trainer human = new Trainer("User", humanMonsters);
        Monster[] computerMonsters = new Monster[]{new Monster("Bulbasaur"), new Monster("Geodude"), new Monster("Pidgey")};
        Trainer computer = new Trainer("Computer", computerMonsters);
        Fight fight = new Fight(human, computer);
        fight.start();
    }
}
