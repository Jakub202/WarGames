package units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    @Test
    void RangedUnitAttackBonusTest(){
        var ranger1 = new RangedUnit("eks1", 100);
        assertEquals(3,ranger1.getAttackBonus());
    }

    @Test
    void RangedUnitResistBonusAfterNoAttacks(){
        var ranger1 = new RangedUnit("eks1", 100);
        assertEquals(6,ranger1.getResistBonus());
    }

    @Test
    void RangedUnitResistBonusAfterOneAttack(){
        var ranger1 = new RangedUnit("eks1", 100);
        var ranger2 = new RangedUnit("eks2", 100);
        ranger1.attack(ranger2);
        assertEquals(4,ranger2.getResistBonus());
    }

    @Test
    void RangedUnidResistBonusAfterTwoAttacks(){
        var ranger1 = new RangedUnit("eks1", 100);
        var ranger2 = new RangedUnit("eks2", 100);
        ranger1.attack(ranger2);
        ranger1.attack(ranger2);
        assertEquals(2,ranger2.getResistBonus());
    }
}