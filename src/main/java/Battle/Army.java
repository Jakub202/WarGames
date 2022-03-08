package Battle;

import units.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * class representing an army
 */

public class Army {

    private String name;

    /**
     * arrayList containing the units of the army
     */
    private ArrayList<Unit> units;


    private static Random random = new Random();

    /**
     * Army constructor
     *
     * @param name
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<Unit>();
    }

    /**
     * extended Army constructor
     *
     * @param name
     * @param units
     */
    public Army(String name, ArrayList<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    /**
     * adds a unit to the army list
     *
     * @param unit
     */
    public void add(Unit unit) {
        this.units.add(unit);
    }

    /**
     * adds all units to army in a given list
     *
     * @param Units a list with Units
     */
    public void addAll(ArrayList<Unit> Units) {
        for (Unit unit : Units) {
            this.units.add(unit);
        }
    }

    public void addNumberOfUnits(int ammount, Unit unit){
        for(int i = 0; i < ammount; i++){
            this.units.add(unit);
        }
    }

    /**
     * removes given unit from the army
     *
     * @param unit
     */
    public void remove(Unit unit) {
        this.units.remove(unit);
    }

    /**
     * returns true if army has units left
     *
     * @return boolean
     */
    public boolean hasUnits() {
        if (this.units.size() < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * returns army units
     *
     * @return ArrayList<Unit>
     */
    public ArrayList<Unit> getAllUnits() {
        return this.units;
    }

    /**
     * return army size
     *
     * @return int
     */
    public int getSizeOfArmy(){
        return this.units.size();
    }

    /**
     * gets random unit from the army
     *
     * @return Unit
     */
    public Unit getRandom() {
        int index = random.nextInt(this.units.size());
        return this.units.get(index);
    }


    // TODO: add equals, toString and Hashcode methods.


}
