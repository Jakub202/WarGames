package units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {

    @Test
    void commanderUnitConstructorHealthTest(){
        var commander = new CommanderUnit("eks", 100);
        assertEquals(100,commander.getHealth());
    }

    @Test
    void commanderUnitCostructorAttackTest(){
        var commander = new CommanderUnit("eks", 100);
        assertEquals(25,commander.getAttack());
    }

    @Test
    void commanderUnitConstructorArmorTest(){
        var commander = new CommanderUnit("eks", 100);
        assertEquals(15,commander.getArmor());
    }

    @Test
    void commanderUnitAttackBonusAfterNoAttackTest(){
        var commander = new CommanderUnit("eks", 100);
        assertEquals(4,commander.getAttackBonus());
    }

    @Test
    void commanderUnitAttackBonusAfterOneAttackTest(){
        var commander1 = new CommanderUnit("eks1", 100);
        var commander2 = new CommanderUnit("eks2", 100);
        commander1.attack(commander2);
        assertEquals(2,commander1.getAttackBonus());
    }

    @Test
    void commanderUnitResistBonusAfterNoAttackTest(){
        var commander = new CommanderUnit("eks", 100);
        assertEquals(1, commander.getResistBonus());
    }

    @Test
    void commanderUnitResistBonusAfterOneAttackTest(){
        var commander1 = new CommanderUnit("eks1", 100);
        var commander2 = new CommanderUnit("eks2", 100);
        commander1.attack(commander2);
        assertEquals(1,commander2.getResistBonus());
    }
}