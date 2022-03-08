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

    private Random random = new Random();

    public Battle(Army army1, Army army2) {
        this.army1 = army1;
        this.army2 = army2;
    }


    public Army simulate(){
        boolean army1Starts = this.getArmy1Starts();
        boolean unit1HasWon = false;
        boolean unit2HasWon = false;
        var unit1 = army1.getRandom();
        var unit2 = army2.getRandom();
        System.out.println(army1Starts);
        while(army1.hasUnits() && army2.hasUnits()){
            System.out.println(army1.getSizeOfArmy() + " " + army2.getSizeOfArmy());
            if(!unit1HasWon){
                unit1 = army1.getRandom();
                System.out.println("army1 uses a new unit");
            }
            if(!unit2HasWon){
                unit2 = army2.getRandom();
                System.out.println("army 2 uses a new unit");
            }

            if(army1Starts) {
                System.out.println(unit1.getName()+ " vs " + unit2.getName());
                while (unit1.getHealth() > 0 && unit2.getHealth() > 0) {
                    unit1.attack(unit2);
                    if(unit2.getHealth() < 1){
                        break;
                    }
                    unit2.attack(unit1);
                }if(getWinnerUnit(unit1,unit2).equals(unit1)){
                    unit1HasWon = true;
                    unit2HasWon = false;
                    army1Starts = false;
                    army2.remove(unit2);
                    System.out.println("unit1 has won");
                }else{
                    unit1HasWon = false;
                    unit2HasWon = true;
                    army1Starts = true;
                    army1.remove(unit1);
                    System.out.println("unit2 has won");
                }
            }else {
                System.out.println(unit1.getName()+ " vs " + unit2.getName());
                while (unit1.getHealth() > 0 && unit2.getHealth() > 0) {
                    unit2.attack(unit1);
                    if(unit1.getHealth() < 1){
                        break;
                    }
                    unit1.attack(unit2);
                }if(getWinnerUnit(unit1,unit2).equals(unit1)){
                    unit1HasWon = true;
                    unit2HasWon = false;
                    army1Starts = false;
                    army2.remove(unit2);
                    System.out.println("unit1 has won");
                }else{
                    unit1HasWon = false;
                    unit2HasWon = true;
                    army1Starts = true;
                    army1.remove(unit1);
                    System.out.println("unit2 has won");
                }
            }
        }if(army1.hasUnits()){
            System.out.println("Army1 has won");
            return army1;
        }else{
            System.out.println("Army2 has won");
            return army2;
        }
    }



    public boolean getArmy1Starts(){
        int startingArmy = 1 + random.nextInt(2);
        boolean army1Starts;
        if(startingArmy == 1){
            army1Starts = true;
        }else{
            army1Starts = false;
        }
        return army1Starts;
    }

    public Unit getWinnerUnit(Unit unit1, Unit unit2){
        if(unit2.getHealth()<1){
            return unit1;
        }else{
            return unit2;
        }
    }

    public static void main(String[] args){
        var cavalry1 = new CavalryUnit("cavalry1", 100);
        var cavalry2 = new CavalryUnit("cavalry2", 100);
        var cavalry3 = new CavalryUnit("cavalry3", 100);
        var cavalry4 = new CavalryUnit("cavalry4", 100);
        var cavalry5 = new CavalryUnit("cavalry5", 100);
        var army1 = new Army("Army1");
        var army2 = new Army("Army2");
        army1.add(cavalry1);
        army1.add(cavalry2);
        army1.add(cavalry3);
        army1.add(cavalry4);
        army1.add(cavalry5);
        army2.add(cavalry1);
        army2.add(cavalry2);
        army2.add(cavalry3);
        army2.add(cavalry4);
        army2.add(cavalry5);

        var battle = new Battle(army1,army2);
        battle.simulate();


    }
}
