package com.anabelen.analyzeprisoner;

/**
 * Annalyn's Infiltration - A tactical rescue simulation
 * 
 * This class implements the logic for Annalyn's infiltration mission to rescue her friend.
 * Annalyn can perform various actions based on the state of the captors and her friend.
 * 
 * @author Ana Belén Hernández
 * @version 1.0
 * @since 2024
 */
public class AnnalynsInfiltration {
    
    /**
     * Main method demonstrating the functionality of Annalyn's infiltration tactics.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("🏰 Annalyn's Infiltration - Tactical Analysis 🐕");
        System.out.println("=" .repeat(50));
        
        // Example scenario: Knight and archer asleep, prisoner awake, dog present
        GameState gameState = new GameState(false, false, true, true);
        
        System.out.println(gameState);
        System.out.println();
        
        System.out.println("⚔️ Available Actions:");
        System.out.println("   " + GameConstants.FAST_ATTACK + ": " + 
            GameConstants.getActionResult(canFastAttack(gameState.isKnightAwake())));
        System.out.println("   " + GameConstants.SPY + ": " + 
            GameConstants.getActionResult(canSpy(gameState.isKnightAwake(), gameState.isArcherAwake(), gameState.isPrisonerAwake())));
        System.out.println("   " + GameConstants.SIGNAL_PRISONER + ": " + 
            GameConstants.getActionResult(canSignalPrisoner(gameState.isArcherAwake(), gameState.isPrisonerAwake())));
        System.out.println("   " + GameConstants.FREE_PRISONER + ": " + 
            GameConstants.getActionResult(canFreePrisoner(gameState.isKnightAwake(), gameState.isArcherAwake(), 
                gameState.isPrisonerAwake(), gameState.isPetDogPresent())));
        
        System.out.println();
        System.out.println("🎯 Strategic Analysis:");
        if (gameState.isOptimalRescueCondition()) {
            System.out.println("   🎉 OPTIMAL CONDITIONS! All rescue actions are possible!");
        } else if (gameState.areCaptorsAsleep()) {
            System.out.println("   ✅ Good conditions: Captors are asleep, some actions possible");
        } else {
            System.out.println("   ⚠️  Challenging conditions: Captors are awake, limited options");
        }
    }

    /**
     * Determines if Annalyn can perform a fast attack.
     * A fast attack is only possible when the knight is asleep.
     * 
     * @param knightIsAwake true if the knight is awake, false if asleep
     * @return true if Annalyn can attack quickly (knight is asleep)
     */
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    /**
     * Determines if Annalyn can spy on the group.
     * Spying is possible when at least one person is awake.
     * 
     * @param knightIsAwake true if the knight is awake
     * @param archerIsAwake true if the archer is awake
     * @param prisonerIsAwake true if the prisoner is awake
     * @return true if Annalyn can spy (at least one person is awake)
     */
    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    /**
     * Determines if Annalyn can signal the prisoner.
     * Signaling is only possible when the prisoner is awake and the archer is asleep.
     * 
     * @param archerIsAwake true if the archer is awake
     * @param prisonerIsAwake true if the prisoner is awake
     * @return true if Annalyn can signal the prisoner
     */
    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    /**
     * Determines if Annalyn can free the prisoner.
     * The conditions depend on whether Annalyn has her dog:
     * - With dog: Only requires the archer to be asleep
     * - Without dog: Requires the prisoner to be awake AND both knight and archer to be asleep
     * 
     * @param knightIsAwake true if the knight is awake
     * @param archerIsAwake true if the archer is awake
     * @param prisonerIsAwake true if the prisoner is awake
     * @param petDogIsPresent true if Annalyn has her dog
     * @return true if Annalyn can free the prisoner
     */
    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, 
                                        boolean prisonerIsAwake, boolean petDogIsPresent) {
        if (petDogIsPresent) {
            // With dog: only need archer to be asleep
            return !archerIsAwake;
        } else {
            // Without dog: prisoner must be awake AND both captors must be asleep
            return prisonerIsAwake && !knightIsAwake && !archerIsAwake;
        }
    }
    
    // ===== OVERLOADED METHODS USING GAMESTATE =====
    
    /**
     * Determines if Annalyn can perform a fast attack using game state.
     * 
     * @param gameState the current game state
     * @return true if Annalyn can attack quickly
     */
    public static boolean canFastAttack(GameState gameState) {
        return canFastAttack(gameState.isKnightAwake());
    }
    
    /**
     * Determines if Annalyn can spy using game state.
     * 
     * @param gameState the current game state
     * @return true if Annalyn can spy
     */
    public static boolean canSpy(GameState gameState) {
        return canSpy(gameState.isKnightAwake(), gameState.isArcherAwake(), gameState.isPrisonerAwake());
    }
    
    /**
     * Determines if Annalyn can signal the prisoner using game state.
     * 
     * @param gameState the current game state
     * @return true if Annalyn can signal the prisoner
     */
    public static boolean canSignalPrisoner(GameState gameState) {
        return canSignalPrisoner(gameState.isArcherAwake(), gameState.isPrisonerAwake());
    }
    
    /**
     * Determines if Annalyn can free the prisoner using game state.
     * 
     * @param gameState the current game state
     * @return true if Annalyn can free the prisoner
     */
    public static boolean canFreePrisoner(GameState gameState) {
        return canFreePrisoner(gameState.isKnightAwake(), gameState.isArcherAwake(), 
                              gameState.isPrisonerAwake(), gameState.isPetDogPresent());
    }
    
    /**
     * Gets a comprehensive analysis of all possible actions for the given game state.
     * 
     * @param gameState the current game state
     * @return formatted string with all action possibilities
     */
    public static String getActionAnalysis(GameState gameState) {
        StringBuilder analysis = new StringBuilder();
        analysis.append("🎯 Tactical Analysis:\n");
        analysis.append("   ").append(GameConstants.FAST_ATTACK).append(": ")
               .append(GameConstants.getActionResult(canFastAttack(gameState))).append("\n");
        analysis.append("   ").append(GameConstants.SPY).append(": ")
               .append(GameConstants.getActionResult(canSpy(gameState))).append("\n");
        analysis.append("   ").append(GameConstants.SIGNAL_PRISONER).append(": ")
               .append(GameConstants.getActionResult(canSignalPrisoner(gameState))).append("\n");
        analysis.append("   ").append(GameConstants.FREE_PRISONER).append(": ")
               .append(GameConstants.getActionResult(canFreePrisoner(gameState)));
        return analysis.toString();
    }
}
