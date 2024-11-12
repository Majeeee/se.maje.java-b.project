package se.maje.adventure.model;

import se.maje.adventure.HouseConstatants;

import java.util.Scanner;

public abstract class Entity {

    String role;
    int health;
    int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
//    public void punch(Entity toPunch);
//
//    public void takeHit(int damage) {
//
//    public void addDamage(int damage){
//        this.damage += damage;
//    }

    private static int attack(Entity attacker, Entity defender) {
        int damageFrying = 0;
        if ((!attacker.getRole().equals("Burglar")) && HouseConstatants.residentCurrentLocation.equals(HouseConstatants.KITCHEN)) {
            damageFrying = fryingPan(attacker);
            if (damageFrying != 0) {
//                defender.setHealth(defender.health- damageFrying);
                return defender.health = defender.getHealth() - damageFrying;
            } else {
                return defender.health = defender.getHealth() - attacker.getDamage();
            }
        }
        defender.setHealth(defender.health- attacker.getDamage());
        return defender.health- attacker.getDamage();

    }

    public boolean isConscious() {
        return this.health > 0;
    }

    public static void showHealth(Entity attacker, Entity defender) {
        System.out.println(defender.getRole() + " have " + defender.getHealth() + " remain health");
        System.out.println(attacker.getRole() + " have " + attacker.getHealth() + " remain health");
    }

    private static void executeAttack(Entity attacker, Entity defender) {
        System.out.println(attacker.getRole() + " attacks " + defender.getRole());
        attack(attacker, defender);

        if (defender.isConscious() == true) {
            System.out.println(defender.getRole() + " have " + defender.getHealth() + " remain health");
        } else {
            System.out.println(defender.getRole() + " died!!\n" +
                    "===========================");
        }
    }


    public static int fryingPan(Entity defender) {
        int damageFrying = 0;
        if (HouseConstatants.residentCurrentLocation.equals(HouseConstatants.KITCHEN)) {
            System.out.println("Do you want frying pan for attacking to burglar?Yes/NO");
            Scanner scanner = new Scanner(System.in);
            String val = scanner.nextLine();
            if (val.equals("ja")) {
                damageFrying = defender.getDamage() + HouseConstatants.damageFrying;
                defender.setDamage(defender.getDamage() + HouseConstatants.damageFrying);
            }
        }
        return damageFrying;
    }

    public static void fightOneRound(Entity attacker, Entity defender) {

        executeAttack(attacker, defender);
        if (defender.isConscious() == true) {
            executeAttack(defender, attacker);
        }
        if (attacker.isConscious() == true && defender.isConscious() == false && !attacker.getRole().equals("Burglar") ) {
            System.out.println("Do you want contact with police station?Yes or NO");
            Scanner scanner = new Scanner(System.in);
            String val = scanner.nextLine();
            if (val.equals("ja")) {
                System.out.println("Alarm have sent to police statation,the police on the way...");
            }else System.out.println("Good Luck");

        }

    }

}




