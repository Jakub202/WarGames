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

    public static void main(String[] args){
        int army1Wins = 0;
        int army2Wins = 0;


        for(int i = 0; i < 100000; i++){
            var cavalry1 = new CavalryUnit("cavalry1", 10);
            var cavalry2 = new CavalryUnit("cavalry2", 10);
            var cavalry3 = new CavalryUnit("cavalry3", 10);
            var cavalry4 = new CavalryUnit("cavalry4", 10);
            var cavalry5 = new CavalryUnit("cavalry5", 10);
            var cavalry6 = new CavalryUnit("cavalry6", 10);
            var army1 = new Army("Army1");
            var army2 = new Army("Army2");

            army1.addNumberOfUnits(10,cavalry1);
            army2.addNumberOfUnits(10,cavalry1);

            var battle = new Battle(army1,army2);
            if(battle.simulate().getName().equalsIgnoreCase("army1")){
                army1Wins++;
            }else{
                army2Wins++;
            }
        }

        System.out.println(army1Wins);
        System.out.println(army2Wins);

    }
}
