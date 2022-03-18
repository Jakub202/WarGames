package Battle;

import units.CavalryUnit;
import units.Unit;

import java.util.Random;

/**
 * class representing a battle of two armies
 */
public class Battle {
    private Army army1;

    private Army army2;

    private static Random random = new Random();

    public Battle(Army army1, Army army2) {
        this.army1 = army1;
        this.army2 = army2;
    }


    public Army simulate(){
        boolean army1Starts = army1Starts();
        boolean unit1HasWon = false;
        boolean unit2HasWon = false;
        var unit1 = army1.getRandom();
        var unit2 = army2.getRandom();
        while(army1.hasUnits() && army2.hasUnits()){
            if(!unit1HasWon){
                unit1 = army1.getRandom();
            }
            if(!unit2HasWon){
                unit2 = army2.getRandom();
            }

            Unit winner = fight(unit1,unit2,army1Starts);
            if(winner.equals(unit1)){
                army2.remove(unit2);
                army1Starts = false;
                unit1HasWon = true;
                unit2HasWon = false;
            }else{
                army1.remove(unit1);
                army1Starts = true;
                unit1HasWon = false;
                unit2HasWon = true;
            }


        }if(army1.hasUnits()){
            return army1;
        }else{
            return army2;
        }
    }



    public static boolean army1Starts(){
        int startingArmy = 1 + random.nextInt(2);
        boolean army1Starts;
        if(startingArmy == 1){
            army1Starts = true;
        }else{
            army1Starts = false;
        }
        return army1Starts;
    }

    public static Unit getWinnerUnit(Unit unit1, Unit unit2){
        if(unit2.getHealth()<1){
            return unit1;
        }else{
            return unit2;
        }
    }

    public static Unit fight(Unit unit1, Unit unit2, boolean army1Starts){
        if(army1Starts){
            while (unit1.getHealth() > 0 && unit2.getHealth() > 0) {
                unit1.attack(unit2);
                if(unit2.getHealth() < 1){
                    break;
                }
                unit2.attack(unit1);
            }
        }else{
            while (unit1.getHealth() > 0 && unit2.getHealth() > 0) {
                unit2.attack(unit1);
                if(unit1.getHealth() < 1){
                    break;
                }
                unit1.attack(unit2);
            }
        }
        return getWinnerUnit(unit1,unit2);
    }

}

