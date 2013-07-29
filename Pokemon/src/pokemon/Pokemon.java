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
        //create an array of monsters 
        Monster[] humanMonsters = new Monster[]{new Monster("Charmander"), new Monster("Squirtle"), new Monster("Pikachu")};
        //create a trainer with name "User" and give him the 3 monsters in the array
        Trainer human = new Trainer("User", humanMonsters);
        //create an array of monsters for computer
        Monster[] computerMonsters = new Monster[]{new Monster("Bulbasaur"), new Monster("Geodude"), new Monster("Pidgey")};
        //create a Trainer named computer and give him the 3 monsters from the array
        Trainer computer = new Trainer("Computer", computerMonsters);
        //create a fight class and input human and computer to fight
        Fight fight = new Fight(human, computer);
        fight.start();
    }
}
