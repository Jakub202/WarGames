package units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class for cavalry class
 */
class CavalryUnitTest {

    @Test
    void cavalryConstructorHealthTest(){
        var cavalry = new CavalryUnit("eks", 100);
        assertEquals(100,cavalry.getHealth());
    }

    @Test
    void cavalryConstructorAttackTest(){
        var cavalry = new CavalryUnit("eks", 100);
        assertEquals(20,cavalry.getAttack());
    }

    @Test
    void cavalryConstructorArmorTest(){
        var cavalry = new CavalryUnit("eks", 100);
        assertEquals(12,cavalry.getArmor());
    }

    @Test
    void cavalryResistBonusTest(){
        var cavalry = new CavalryUnit("eks", 100);
        assertEquals(1,cavalry.getResistBonus());
    }

    @Test
    void cavalryAttackBonusAfterNoAttacksTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        assertEquals(4, cavalry1.getAttackBonus());
    }

    @Test
    void cavalryAttackBonusAfterOneAttackTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        var cavalry2 = new CavalryUnit("eks2", 100);
        cavalry1.attack(cavalry2);
        assertEquals(2, cavalry1.getAttackBonus());
    }

    @Test
    void cavalryResistBonusAfterNoAttacksTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        assertEquals(1,cavalry1.getResistBonus());

    }

    @Test
    void cavalryResistBonusAfterOneAttackTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        var cavalry2 = new CavalryUnit("eks2", 100);
        cavalry2.attack(cavalry1);
        assertEquals(1,cavalry1.getResistBonus());
    }

    @Test
    void cavalryFirstAttackTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        var cavalry2 = new CavalryUnit("eks2", 100);
        cavalry1.attack(cavalry2);

        assertEquals(89,cavalry2.getHealth());
    }

    @Test
    void cavalrySecondAttackTest(){
        var cavalry1 = new CavalryUnit("eks1", 100);
        var cavalry2 = new CavalryUnit("eks2", 100);
        cavalry1.attack(cavalry2);
        cavalry1.attack(cavalry2);
        assertEquals(80, cavalry2.getHealth());
    }

    @Test
    void ArmorBiggerThanAttackTest(){
        var cavalry1 = new CavalryUnit("eks1", 100,2,10);
        var cavalry2 = new CavalryUnit("eks2", 100, 2, 5);
        cavalry1.attack(cavalry2);
        assertEquals(100, cavalry2.getHealth());
    }

}