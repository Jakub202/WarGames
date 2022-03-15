package units;

/**
 * abstract class representing a Unit
 */
public abstract class Unit {
    /**
     * name of unit
     */
    private String name;

    /**
     * amount of health
     */
    private int health;

    /**
     * attack strength
     */
    private int attack;

    /**
     * strength of armor
     */
    private int armor;

    /**
     * number of attacks dealt
     */
    private int nrOfAttacksDealt = 0;


    /**
     * number of attacks taken
     */

    private int nrOfAttacksTaken = 0;

    private boolean recruited = false;


    /**
     * constructor for Unit class
     * @param name
     * @param health
     * @param attack
     * @param armor
     */

    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * method for attacking
     * @param opponent
     */
    public void attack(Unit opponent){
        int attack = this.attack + this.getAttackBonus();
        int armor = opponent.getArmor() + this.getResistBonus();

        if(attack > armor){
            int newHealth = opponent.getHealth() + armor - attack;
            opponent.setHealth(newHealth);
        }
        this.nrOfAttacksDealt++;
        opponent.nrOfAttacksTaken++;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public int getNrOfAttacksDealt() {
        return nrOfAttacksDealt;
    }

    public int getNrOfAttacksTaken() {
        return nrOfAttacksTaken;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract int getAttackBonus();

    public abstract int getResistBonus();

    /**
     * toString method
     * @return String
     */
    public String toString(){
        String output = "Name: " + this.getName() + "\nHealth: " + this.getHealth() + "\nAttack strength: " + this.getAttack() + "\nArmor strength: " + this.getArmor() + "\nAttacks Dealt: " + this.getNrOfAttacksDealt() + "\nAttacks Taken: " + this.getNrOfAttacksTaken();

        return output;
    }

}
