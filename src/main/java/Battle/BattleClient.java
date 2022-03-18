package Battle;

import units.CavalryUnit;
import units.CommanderUnit;
import units.InfantryUnit;
import units.RangedUnit;

import java.util.Scanner;

/**
 * Client for battle
 */

public class BattleClient {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the WarGames!");
        System.out.println();
        System.out.println("Choose your army!\nTo choose the human army type 1, to choose the orcish horde, type 2");

        int UserChoice = scanner.nextInt();
        if(UserChoice == Example()){
            System.out.println("You Won!");
        }else{
            System.out.println("You lost!");
        }


    }

    private static int Example(){
        Army human = new Army("Human Army");
        Army orc = new Army("Orcish Horde");

        InfantryUnit Footman = new InfantryUnit("Footman", 100);
        CavalryUnit Knight = new CavalryUnit("Knight",100);
        RangedUnit Archer = new RangedUnit("Archer", 100);
        CommanderUnit MountainKing = new CommanderUnit("Mountain King", 180);

        InfantryUnit Grunt = new InfantryUnit("Grunt", 100);
        CavalryUnit Raider = new CavalryUnit("Raider",100);
        RangedUnit Spearman = new RangedUnit("Spearman", 100);
        CommanderUnit GulDan = new CommanderUnit("Gul'dan", 180);

        human.addNumberOfUnits(500,Footman);
        human.addNumberOfUnits(100,Knight);
        human.addNumberOfUnits(200,Archer);
        human.add(MountainKing);

        orc.addNumberOfUnits(500,Grunt);
        orc.addNumberOfUnits(100,Raider);
        orc.addNumberOfUnits(200,Spearman);
        orc.add(GulDan);

        Battle battle = new Battle(human,orc);
        if(battle.simulate().equals(human)){
            return 1;
        }else{
            return 2;
        }
    }
}
