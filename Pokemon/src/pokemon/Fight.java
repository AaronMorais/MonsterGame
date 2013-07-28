/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.Scanner;

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
        Monster computerMonster = computer.currentMonster();
        Monster humanMonster = human.currentMonster();
        
        while(true){
            printStatus();

            int moveIndex = -1;
            while((moveIndex>4) || (moveIndex < 1)) {
                System.out.println("What will you do?");
                Scanner in = new Scanner(System.in);
                moveIndex = in.nextInt();
            }
            moveIndex--;
            
            boolean fainted = attackMonster(moveIndex, humanMonster, computerMonster);
            System.out.println(humanMonster.name + " used " + humanMonster.moveNames[moveIndex]);
            if (fainted) {
                System.out.println(computerMonster.name + " has fainted");
                computer.currentMonsterIndex++;
                if (computer.currentMonsterIndex >= computer.monsters.length) {
                    System.out.println("Computer blacked out. You win!"); 
                    break;
                } else {                
                    computerMonster = computer.currentMonster();
                    System.out.println("Computer sends out " + computerMonster.name);
                }
            }

            moveIndex = 0;
            fainted = attackMonster(moveIndex, computerMonster, humanMonster);
            System.out.println(computerMonster.name + " used " + computerMonster.moveNames[moveIndex]);
            if (fainted) {
                System.out.println(humanMonster.name + " has fainted");
                human.currentMonsterIndex++;
                if (human.currentMonsterIndex >= human.monsters.length) {
                    System.out.println("You blacked out. You lose!"); 
                    break;
                } else {                
                    humanMonster = human.currentMonster();
                    System.out.println("You send out " + humanMonster.name);
                }
            }
        }
    }
    
    public boolean attackMonster(int move, Monster attacker, Monster victim) {
        int damage = attacker.moves[move];
        victim.hp = Math.max(0, victim.hp+damage);
        return victim.hp == 0;
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
