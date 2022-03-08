package units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {

    @Test
    void InfantryConstructorHealthTest(){
        var infantry = new InfantryUnit("eks", 100);
        assertEquals(100, infantry.getHealth());
    }

    @Test
    void infantryConstructorAttackTest(){
        var infantry = new InfantryUnit("eks", 100);
        assertEquals(15,infantry.getAttack());
    }


    @Test
    void infantryConstructorArmorTest(){
        var infantry = new InfantryUnit("eks", 100);
        assertEquals(10, infantry.getArmor());
    }

    @Test
    void infantryAttackBonusTest(){
        var infantry = new InfantryUnit("eks", 100);
        assertEquals(2, infantry.getAttackBonus());
    }

    @Test
    void infantryResistBonusTest(){
        var infantry = new InfantryUnit("eks", 100);
        assertEquals(1,infantry.getResistBonus());
    }
}