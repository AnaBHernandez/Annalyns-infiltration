package com.anabelen.analyzeprisoner;

public class AnnalynsInfiltration {
    public static void main(String[] args) {
        // Ejemplo de uso de los métodos
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;

        System.out.println("Can attack quickly: " + canFastAttack(knightIsAwake));
        System.out.println("You can spy: " + canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
        System.out.println("You can send signals to the prisoner: " + canSignalPrisoner(archerIsAwake, prisonerIsAwake));
        System.out.println("You can free the prisoner: " + canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        if (petDogIsPresent) {
            return !archerIsAwake;
        } else {
            return prisonerIsAwake && !knightIsAwake && !archerIsAwake;
        }
    }
}
