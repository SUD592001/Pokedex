import java.util.*;
public class PakuriProgram {
    Scanner response = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner response = new Scanner(System.in);
        String species = "";
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        boolean exit = false;
        int size = catchError(response);
        Pakudex pakudex = new Pakudex(size);
        while (size < 0) {
            System.out.println("Please enter a valid size.");
            System.out.println("Enter max capacity of the Pakudex: ");
            size = catchError(response);
        }


        System.out.println("The Pakudex can hold " + size + " species of Pakuri.");
        //While loop created to allow user to exit program whenever they want.
        while (exit != true && size > 0) {
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("What would you like to do?");
            int option = catchSelectionError(response);
            //If-else statements used to prompt program to carry out certain actions based on user input.
            if (option == 1) {
                String[] pakuris = pakudex.getSpeciesArray();
                if (pakuris == null)
                    System.out.println("No Pakuri in Pakudex yet!");
                else {
                    System.out.println("Pakuri In Pakudex:");
                    for (int i = 0; i < pakuris.length; i++) {

                        System.out.println((i + 1) + ". " + pakuris[i]);
                    }

                }
            } else if (option == 2) {
                System.out.println("Enter the name of the species to display: ");
                species = response.next();
                int[] stats = pakudex.getStats(species);

                if (stats == null)
                    System.out.println("Error: No such Pakuri!");
                else {
                    //Lists stats of pakuri species and takes data from an array.
                    System.out.println("Species: " + species);
                    System.out.println("Attack: " + stats[0]);
                    System.out.println("Defense: " + stats[1]);
                    System.out.println("Speed: " + stats[2]);
                }
            } else if (option == 3) {
                pakudex.addPakuri(species);
            } else if (option == 4) {
                System.out.println("Enter the name of the species to evolve:");
                 species = response.next();
                pakudex.evolveSpecies(species);
            } else if (option == 5) {
                pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            } else if (option == 6) {
                exit = true;
                System.out.println("Thanks for using Pakudex! Bye!");
            } else {
                System.out.println("Unrecognized menu selection!");
            }
        }


    }

    //Method catches input mismatch error for number of pakudex size and asks user to input a valid answer.
    public static int catchError(Scanner response) {
        while (true) {
            try {
                return response.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid size. ");
                System.out.println("Enter max capacity of the Pakudex: ");
                response.next();
            }
        }


    }

    //Method catches input mismatch error for user selection and asks user to input a valid answer.
    public static int catchSelectionError(Scanner response) {
        while (true) {
            try {
                return response.nextInt();
            } catch (InputMismatchException e) {
                response.next();
                System.out.println("Unrecognized menu selection! ");
                System.out.println("Pakudex Main Menu");
                System.out.println("------------------");
                System.out.println("1. List Pakuri");
                System.out.println("2. Show Pakuri");
                System.out.println("3. Add Pakuri");
                System.out.println("4. Evolve Pakuri");
                System.out.println("5. Sort Pakuri");
                System.out.println("6. Exit");
                System.out.println();
                System.out.println("What would you like to do?");
            }
        }



        }
    }




