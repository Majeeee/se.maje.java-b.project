package se.maje.adventure;

import java.util.Scanner;


public class Direction {

    private Scanner scanner; // Create a Scanner object



    public Direction(Scanner scanner) {
        this.scanner = scanner;
    }

    public Direction() {

    }

    private void printWelcometMenu() {
        setBurglarLocation();
// Loopen kommer att köras så länge 'running' är true
        System.out.println("Vilken riktning de vill gå, och ange att giltiga värden är nedanstående\n" +


                "1. Go to kitchen\n" +
                "2. Go to bedroom\n" +
                "3. Go to hall\n" +
                "4. Go to bathroom \n" +
                "5. Go to house center \n" +
                "6. Exit \n" +
                "Residenet current location is " + HouseConstatants.residentCurrentLocation + " \n" +
                "Burglar current location is " + HouseConstatants.burglarCurrentLocation + " \n" +
                "Enter valet: ");
    }

    int getUserInput() {
        int val = scanner.nextInt();
        return val;
    }

    boolean processInput(int valinput) {

        if (!HouseConstatants.residentCurrentLocation.equals(HouseConstatants.HOUSE_CENTER)) {

            switch (valinput) {
                case 1:
                    HouseConstatants.residentCurrentLocation = HouseConstatants.KITCHEN;
                    System.out.println("Going " + HouseConstatants.residentCurrentLocation + " \n \n" +
                            " =================================\n" + "Enter your choice: ");
                    break;
                case 2:
                    HouseConstatants.residentCurrentLocation = HouseConstatants.BEDROOM;
                    System.out.println("Going " + HouseConstatants.residentCurrentLocation + " \n \n" +
                            " =================================\n" + "Enter your choice: ");
                    break;
                case 3:
                    HouseConstatants.residentCurrentLocation = HouseConstatants.HALL;
                    System.out.println("Going " + HouseConstatants.residentCurrentLocation + " \n \n" +
                            " =================================\n" + "Enter your choice: ");
                    break;
                case 4:
                    HouseConstatants.residentCurrentLocation = HouseConstatants.BATHROOM;
                    System.out.println("Going " + HouseConstatants.residentCurrentLocation + " \n \n" +
                            " =================================\n" + "Enter your choice: ");
                    break;
                case 5:
                    HouseConstatants.residentCurrentLocation = HouseConstatants.HOUSE_CENTER;
                    System.out.println("Going " + HouseConstatants.residentCurrentLocation + " \n \n" +
                            " =================================\n" + "Enter your choice: ");
                    break;
                case 6:
                    System.out.println("Exiting the game...");
                    return false;
                // Stop running when user chooses to exit

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

        } else {
            System.out.println("Resident can not go here just now!");
            return true;
        }
        return true;
    }

    public boolean setBurglarLocation() {
       int monsterRandomCurrentLocation =      (int) Math.floor(Math.random() * 4)+1;
//        int monsterRandomCurrentLocation =    1;

        switch (monsterRandomCurrentLocation) {
            case 1:
                HouseConstatants.burglarCurrentLocation = HouseConstatants.KITCHEN;
                break;
            case 2:
                HouseConstatants.burglarCurrentLocation = HouseConstatants.BEDROOM;
                break;
            case 3:
                HouseConstatants.burglarCurrentLocation = HouseConstatants.HALL;
                break;
            case 4:
                HouseConstatants.burglarCurrentLocation = HouseConstatants.BATHROOM;
                break;
            case 5:
                HouseConstatants.burglarCurrentLocation = HouseConstatants.HOUSE_CENTER;
                break;
        }
        return true;
    }

    public void start() {
        printWelcometMenu();
        while (HouseConstatants.running) {
            processInput(getUserInput());
            if (HouseConstatants.residentCurrentLocation.equals(HouseConstatants.burglarCurrentLocation))
                return;
        }
    }
}
