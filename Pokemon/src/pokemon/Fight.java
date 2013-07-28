/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.Scanner;
import pokemon.Monster.MonsterType;

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
        
        while(!gameOver()){
            printStatus();

            int moveIndex = -1;
            while((moveIndex>4) || (moveIndex < 1)) {
                System.out.println("What will you do?");
                Scanner in = new Scanner(System.in);
                moveIndex = in.nextInt();
            }
            System.out.println("");
            moveIndex--;                        
            boolean fainted = attackMonster(moveIndex, human, computer);      
            
            if (!fainted) { 
                moveIndex = (int)(Math.random()*4);
                attackMonster(moveIndex, computer, human);
            }
            System.out.println("");
        }
    }
    
    public boolean gameOver() {
        return ((computer.currentMonsterIndex >= computer.monsters.length) || (human.currentMonsterIndex >= human.monsters.length));
    }
    
    public boolean attackMonster(int moveIndex, Trainer attacker, Trainer victim) {
        Monster attackerMonster = attacker.currentMonster();
        Monster victimMonster = victim.currentMonster();
        
        System.out.println(attackerMonster.name + " used " + attackerMonster.moveNames[moveIndex]);
        
        int damage = calculateDamage(moveIndex, attackerMonster, victimMonster) ;
        victimMonster.hp = Math.max(0, victimMonster.hp+damage);
        
        if (victimMonster.hp == 0) {
                System.out.println(victim.name + "'s " + victimMonster.name + " has fainted");
                victim.currentMonsterIndex++;
                if (victim.currentMonsterIndex >= victim.monsters.length) {
                    System.out.println(victim.name + " blacked out. " + attacker.name + " is the winner!" ); 
                } else {                
                    victimMonster = victim.currentMonster();
                    System.out.println(victim.name + " sends out " + victimMonster.name);
                }
                return true;
        }
        return false;
    }
    
    public enum AttackEffectiveness {
        SUPER_EFFECTIVE, NEUTRAL, NOT_VERY_EFFECTIVE
    }
    
    public int calculateDamage(int moveIndex, Monster attacker, Monster victim) {
        int damage = attacker.moves[moveIndex];
        damage *= (attacker.attack/100) + 1;
        damage *= (1 -((victim.defense/100)/2));
        AttackEffectiveness effectiveness = calculateEffectiveness(attacker.type, victim.type);
        switch(effectiveness) {
            case SUPER_EFFECTIVE:
                damage *= 2;
                System.out.println("It's super effective!");
                break;
            case NEUTRAL:
                break;
            case NOT_VERY_EFFECTIVE:
                damage *= 0.5;
                System.out.println("It's not very effective...");
                break;
        }
        return damage;
    }
    
    public AttackEffectiveness calculateEffectiveness(MonsterType attacker, MonsterType victim){
        switch(attacker) {
            case WATER:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.NEUTRAL;
                    case FIRE:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case GRASS:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case ELECTRIC:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case GROUND:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case FLYING:
                        return AttackEffectiveness.NEUTRAL;
                }
            case FIRE:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case FIRE:
                        return AttackEffectiveness.NEUTRAL;
                    case GRASS:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case ELECTRIC:
                        return AttackEffectiveness.NEUTRAL;
                    case GROUND:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case FLYING:
                        return AttackEffectiveness.NEUTRAL;
                }
            case GRASS:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case FIRE:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case GRASS:
                        return AttackEffectiveness.NEUTRAL;
                    case ELECTRIC:
                        return AttackEffectiveness.NEUTRAL;
                    case GROUND:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case FLYING:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                }
            case ELECTRIC:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case FIRE:
                        return AttackEffectiveness.NEUTRAL;
                    case GRASS:
                        return AttackEffectiveness.NEUTRAL;
                    case ELECTRIC:
                        return AttackEffectiveness.NEUTRAL;
                    case GROUND:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case FLYING:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                }
            case GROUND:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case FIRE:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case GRASS:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case ELECTRIC:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case GROUND:
                        return AttackEffectiveness.NEUTRAL;
                    case FLYING:
                        return AttackEffectiveness.NEUTRAL;
                }
            case FLYING:
                switch(victim) {
                    case WATER:
                        return AttackEffectiveness.NEUTRAL;
                    case FIRE:
                        return AttackEffectiveness.NEUTRAL;
                    case GRASS:
                        return AttackEffectiveness.SUPER_EFFECTIVE;
                    case ELECTRIC:
                        return AttackEffectiveness.NOT_VERY_EFFECTIVE;
                    case GROUND:
                        return AttackEffectiveness.NEUTRAL;
                    case FLYING:
                        return AttackEffectiveness.NEUTRAL;
                }          
        }      
        return AttackEffectiveness.NEUTRAL;
   }
    
    public void printStatus() {
        Monster computerMonster = computer.currentMonster();
        System.out.println(computer.name + "'s " + computerMonster.name);
        System.out.println("HP: " + computerMonster.hp );
        System.out.println("vs.");
        Monster humanMonster = human.currentMonster();
        System.out.println(human.name + "'s " + humanMonster.name);
        System.out.println("HP: " + humanMonster.hp);
        System.out.println("Moves: ");
        for(int i=0; i<humanMonster.moves.length; i++) {
            System.out.println(i+1 + "- " + humanMonster.moveNames[i]);
        }
    }
}
