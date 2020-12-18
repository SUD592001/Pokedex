import java.util.*;
import java.util.ArrayList;
public class Pakudex {
    private ArrayList<Pakuri> pakudex = new ArrayList();
    Pakuri[] pakuri;
    private int capacity1 = 20;

    public Pakudex() {

    }

    public Pakudex(int capacity) {
        capacity1 = capacity;
    }


    public int getSize() {
        return pakudex.size();
    }

    public int getCapacity() {
        return capacity1;
    }


    //Method returns array with ordered pakudex and arranged pakuri species.
    public String[] getSpeciesArray() {
        if (pakudex.size() <= 0) {
            return null;
        }
        String[] speciesNames = new String[pakudex.size()];
        int i = 0;
        for (Pakuri species : pakudex) {
            speciesNames[i] = species.getSpecies();
            i++;
        }
        return speciesNames;
    }

    //Method shows base stats of pakuri species based on user input.
    public int[] getStats(String species) {
        Pakuri pakuri = getPakuri(species);
        if (pakuri == null) {
            return null;
        }
        //Sets position in array for pakuri species' attack, defense and speed statistics.
        int[] stats = new int[3];
        stats[0] = pakuri.getAttack();
        stats[1] = pakuri.getDefense();
        stats[2] = pakuri.getSpeed();
        return stats;
    }

    //Method adds pakuri species to array based on user input.
    public boolean addPakuri(String species) {
        Scanner response = new Scanner(System.in);
        if (pakudex.size() >= capacity1) {
            System.out.println("Error: Pakudex is full!");
            return false;
        } else {
            System.out.println("Enter the name of the species to add: ");
            species = response.next();
            if (pakudex.contains(getPakuri(species))) {
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
            //Adds new pakuri species if not in array already
            pakudex.add(new Pakuri(species));
            System.out.println("Pakuri species " + species + " successfully added!");
            return true;

        }
    }


    //Method increases stats of pakuri species based on user input.
    public boolean evolveSpecies(String species) {
        if (pakudex.contains(getPakuri(species))) {
            getPakuri(species).evolve();
            System.out.println(species + " has evolved!");
            return true;
        } else {
            System.out.println("Error: No such Pakuri!");
            return false;
        }
    }

    //Methods sorts pakuri species in lexicographical order.
    public void sortPakuri() {
        {
            ArrayList<Pakuri> sortedList = new ArrayList();
            String[] pakuriName = new String[pakudex.size()];
            int i = 0;
            for (Pakuri pak : pakudex) {
                pakuriName[i] = pak.getSpecies();
                i++;
            }
           Arrays.sort(pakuriName);
            for (String species : pakuriName) {
               sortedList.add(getPakuri(species));
            }pakudex = sortedList;

        }
    }


    public Pakuri getPakuri(String species) {
        for (Pakuri pak : pakudex) {
            if (pak.getSpecies().equals(species)) {
                return pak;
            }
        }
        return null;
    }
}








