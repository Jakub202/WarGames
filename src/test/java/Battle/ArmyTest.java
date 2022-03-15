package Battle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;
import units.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    Army army1;
    Army army2;
    CavalryUnit cavalry;
    InfantryUnit infantry;
    RangedUnit ranged;

    @BeforeEach
    void init(){
        army1 = new Army("army1");
        army2 = new Army("army2");
        ranged = new RangedUnit("ranged",100);
        cavalry = new CavalryUnit("cavalry",100);
        infantry = new InfantryUnit("infantry",100);
    }

    @Test
    void addMethodTest(){
        army1.add(cavalry);
        army1.add(infantry);
        assertEquals(infantry,army1.getAllUnits().get(1));
    }

    @Test
    void addAllMethodTest(){
        ArrayList<Unit> list = new ArrayList<>();

        list.add(cavalry);
        list.add(cavalry);
        list.add(cavalry);
        list.add(infantry);
        list.add(infantry);

        army1.addAll(list);

        assertEquals(list, army1.getAllUnits());
    }

    @Test
    void removeMethodTest(){

        army1.add(cavalry);
        army1.add(cavalry);
        army1.add(infantry);
        army1.add(infantry);
        System.out.println(army1);
        army1.remove(cavalry);
        System.out.println(army1);
        assertEquals(3, army1.getSizeOfArmy());
    }

    @Test
    void addNumberOfUnitsTest(){

        army1.addNumberOfUnits(5,cavalry);
        assertEquals(5,army1.getSizeOfArmy());
    }



    @Test
    void getRandomMethodTest(){
        army1.add(cavalry);
        army1.add(infantry);
        army1.add(ranged);
        for(int i = 0; i < 10; i++){
            System.out.println(army1.getRandom().getName());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        army1.remove(cavalry);
        for(int i = 0; i < 10; i++){
            System.out.println(army1.getRandom().getName());
        }
    }

    @Test
    void armyUnitTest(){
        army1.add(ranged);
        army1.add(ranged);
        army2.add(ranged);
        cavalry.attack(army1.getAllUnits().get(0));
        cavalry.attack(army1.getAllUnits().get(0));
        cavalry.attack(army1.getAllUnits().get(0));
        System.out.println(army1.getAllUnits().get(0).getHealth());
        System.out.println(army1.getAllUnits().get(1).getHealth());
        System.out.println(army2.getRandom().getHealth());

    }


    // TODO: test of getRandom method

}