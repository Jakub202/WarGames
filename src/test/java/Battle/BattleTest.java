package Battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import units.CavalryUnit;
import units.InfantryUnit;
import units.Unit;

import static Battle.Battle.fight;
import static Battle.Battle.army1Starts;
import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    Army army1;
    Army army2;
    Battle battle;
    Unit cavalry;
    Unit infantry;

    @BeforeEach
    void init(){
        army1 = new Army("army1");
        army2 = new Army("army2");
        cavalry = new CavalryUnit("cavalry",30);
        infantry = new InfantryUnit("infantry",30);
        battle = new Battle(army1,army2);
        army1.add(cavalry);
        army1.add(infantry);
        army2.add(cavalry);
        army2.add(infantry);
    }

/*    @Test
    void randomStartingArmyNotZeroTest(){
        var army1 = new Army("army1");
        var army2 = new Army("army2");
        var battle = new Battle(army1,army2);
        int numberOfZeros = 0;
        for(int i = 0; i < 1000; i++){
            if(battle.getStartingArmy() == 0){
                numberOfZeros++;
            }
        }

        assertEquals(0,numberOfZeros);
    }

    @Test
    void randomStartingArmyNotThreeTest(){
        var army1 = new Army("army1");
        var army2 = new Army("army2");
        var battle = new Battle(army1,army2);
        int numberOfTwos = 0;
        for(int i = 0; i < 1000; i++){
            if(battle.getStartingArmy() == 3){
                numberOfTwos++;
            }
        }

        assertEquals(0,numberOfTwos);
    }
    */

    @Test
    void fightMethodTest(){
        infantry.setHealth(1);
        System.out.println(fight(infantry,cavalry,false).getName());
        System.out.println(cavalry.getNrOfAttacksDealt());
        System.out.println(infantry.getNrOfAttacksDealt());

    }
}