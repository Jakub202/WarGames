package units;

/**
 * class representing an infantry unit
 */
public class InfantryUnit extends Unit {

    /**
     * Infantry Unit Constructor
     *
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * simplified constructor
     * @param name
     * @param health
     */
    public InfantryUnit(String name, int health){
        super(name, health, 15,10);
    }


    /**
     * method for getting attack bonus
     * @return
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * method for getting resistance bonus
     * @return
     */
    @Override
    public int getResistBonus() {
        return 1;
    }

    @Override
    public Unit copyUnit(){
        return new InfantryUnit(this.getName(),this.getHealth(),this.getAttack(),this.getArmor());
    }
}
