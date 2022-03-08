package units;

/**
 * class representing a commander Unit
 */

public class CommanderUnit extends CavalryUnit{

    /**
     * commander unit constructor
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * simplified constructor
     * @param name
     * @param health
     */

    public CommanderUnit(String name, int health){
        super(name, health, 25,15);
    }
}
