package units;

/**
 * class representing a cavalry Unit
 */
public class CavalryUnit extends Unit{

    /**
     * CavalryUnit Constructor
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * simplified constructor
     * @param name
     * @param health
     */
    public CavalryUnit(String name, int health){
        super(name, health, 20, 12);
    }


    /**
     * method for getting current attack bonus, returns 4 the first attack
     * @return int
     */
    @Override
    public int getAttackBonus() {
        if(this.getNrOfAttacksDealt() < 1){
            return 4;
        }
        else{
            return 2;
        }
    }

    /**
     * method for getting current resist bonus
     * @return int
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
