package units;

/**
 * class representing ranged units
 */
public class RangedUnit extends Unit {

    /**
     * Ranged Unit constructor
     *
     * @param name
     * @param health
     * @param attack
     * @param armor
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * simplified constructor for Ranged Unit
     * @param name
     * @param health
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    /**
     * method for getting attack bonus
     * @return
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * method for getting resistance bonus
     * @return
     */
    @Override
    public int getResistBonus() {
        int bonus = 2;
        if(this.getNrOfAttacksTaken() < 1){
            bonus = 6;
        }else if(this.getNrOfAttacksTaken() < 2){
            bonus = 4;
        }
        return bonus;
    }

    @Override
    public Unit copyUnit(){
        return new RangedUnit(this.getName(),this.getHealth(),this.getAttack(),this.getArmor());
    }
}
