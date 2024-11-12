package se.maje.adventure;

import se.maje.adventure.model.Burglar;
import se.maje.adventure.model.Entity;
import se.maje.adventure.model.Resident;

import java.util.Scanner;

public class Main {

    private static Resident resident;
    private static Burglar burglar;
    private Scanner scanner;

    public static void main(String[] args) {

        Direction direction = new Direction(new Scanner(System.in));

        resident = new Resident("Maje", 12, 3);
        burglar = new Burglar("Burglar", 12, 4);
        direction.start();

        while (HouseConstatants.running = true && resident.isConscious() && burglar.isConscious()) {

            System.out.println("-----------------------------\n \n" +
                    "Do you want fight? Yes/No");
            Entity.showHealth(resident,burglar);
            Scanner scanner = new Scanner(System.in);
            String val = scanner.nextLine();
            if (val.equals("ja")) {
                Entity.fightOneRound(resident, burglar);
            } else {
                HouseConstatants.running = false;
            }
        }
    }
}
