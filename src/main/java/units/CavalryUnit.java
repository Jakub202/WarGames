package units;

public class Cavalry extends Unit{
    public Cavalry(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public Cavalry(String name, int health){
        super(name, health, 20, 12);
    }


    @Override
    public int getAttackBonus() {
        if(this.getNrOfAttacksDealt() < 1){
            return 4;
        }
        else{
            return 2;
        }
    }

    @Override
    public int getResistBonus() {
        return 1;
    }
}
