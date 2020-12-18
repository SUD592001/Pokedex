public class Pakuri implements Comparable <Pakuri> {

    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String _species){
        species = _species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public String getSpecies(){
        return species;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

    public void evolve(){
        speed= speed * 3;
        defense = defense * 4;
        attack = attack * 2;
    }
public int compareTo(Pakuri target) {
        int last = this.species.compareTo(target.species);
        return last;
}
    }

