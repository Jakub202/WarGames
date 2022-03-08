package Battle;

import org.junit.jupiter.api.Test;
import units.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void addMethodTest(){
        var army = new Army("army1");
        var unit = new CavalryUnit("cavalry",100);
        army.add(unit);
        assertEquals(unit, army.getAllUnits().get(0));
    }

    @Test
    void addAllMethodTest(){
        var army = new Army("army1");

        var unit1 = new CavalryUnit("cavalry",100);
        var unit2 = new RangedUnit("ranged",100);
        var unit3 = new RangedUnit("ranged",100);
        var unit4 = new CommanderUnit("commander",100);
        var unit5 = new InfantryUnit("infantry",100);

        ArrayList<Unit> list = new ArrayList<>();

        list.add(unit1);
        list.add(unit2);
        list.add(unit3);
        list.add(unit4);
        list.add(unit5);

        army.addAll(list);

        assertEquals(list, army.getAllUnits());

    }

    @Test
    void removeMethodTest(){
        var army = new Army("army1");
        var unit = new CavalryUnit("cavalry",100);
        var unit2 = new RangedUnit("ranged", 100);

        army.add(unit);
        army.add(unit);
        army.add(unit2);
        army.add(unit2);
        army.remove(unit);


        assertEquals(3, army.getSizeOfArmy());
    }

    @Test
    void addNumberOfUnitsTest(){
        var army = new Army("army1");
        var unit = new CavalryUnit("cavalry",100);
        army.addNumberOfUnits(5,unit);
        assertEquals(5,army.getSizeOfArmy());
    }

/*    @Test
    void getRandomMethodTest(){
        var army = new Army("army1");
        var unit = new CavalryUnit("cavalry",100);
        var unit2 = new CavalryUnit("cavalry2",100);
        var unit3 = new CavalryUnit("cavalry3",100);
        var unit4 = new CavalryUnit("cavalry4",100);
        var unit5 = new CavalryUnit("cavalry5",100);
        var unit6 = new CavalryUnit("cavalry6",100);
        var unit7 = new CavalryUnit("cavalry7",100);

        System.out.println(army.getRandom().getName());
        assertNotEquals(1, army.getSizeOfArmy());
    }*/

    // TODO: test of getRandom method

}