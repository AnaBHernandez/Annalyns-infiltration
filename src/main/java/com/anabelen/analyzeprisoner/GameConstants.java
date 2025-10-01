package com.anabelen.analyzeprisoner;

/**
 * Constants and utility methods for Annalyn's Infiltration game.
 * Contains game rules, character states, and validation logic.
 * 
 * @author Ana Belén Hernández
 * @version 1.0
 * @since 2024
 */
public class GameConstants {
    
    // Character states
    public static final boolean AWAKE = true;
    public static final boolean ASLEEP = false;
    
    // Dog presence
    public static final boolean DOG_PRESENT = true;
    public static final boolean DOG_ABSENT = false;
    
    // Action names for display
    public static final String FAST_ATTACK = "Fast Attack";
    public static final String SPY = "Spy";
    public static final String SIGNAL_PRISONER = "Signal Prisoner";
    public static final String FREE_PRISONER = "Free Prisoner";
    
    // Character names
    public static final String KNIGHT = "Knight";
    public static final String ARCHER = "Archer";
    public static final String PRISONER = "Prisoner";
    public static final String DOG = "Dog";
    
    // Emojis for display
    public static final String AWAKE_EMOJI = "🟢";
    public static final String ASLEEP_EMOJI = "😴";
    public static final String DOG_EMOJI = "🐕";
    public static final String SUCCESS_EMOJI = "✅";
    public static final String FAILURE_EMOJI = "❌";
    
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private GameConstants() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Validates that a boolean parameter is not null (though booleans are primitive).
     * This method is included for consistency and future extensibility.
     * 
     * @param value the boolean value to validate
     * @param paramName the name of the parameter for error messages
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateBooleanParameter(boolean value, String paramName) {
        // Boolean primitives cannot be null, but this method provides
        // a consistent interface for parameter validation
        // In a real application, this might validate business rules
    }
    
    /**
     * Gets a human-readable status string for a character's state.
     * 
     * @param isAwake true if the character is awake
     * @return formatted status string
     */
    public static String getCharacterStatus(boolean isAwake) {
        return isAwake ? AWAKE_EMOJI + " Awake" : ASLEEP_EMOJI + " Asleep";
    }
    
    /**
     * Gets a human-readable status string for dog presence.
     * 
     * @param isPresent true if the dog is present
     * @return formatted status string
     */
    public static String getDogStatus(boolean isPresent) {
        return isPresent ? DOG_EMOJI + " Present" : FAILURE_EMOJI + " Absent";
    }
    
    /**
     * Gets a formatted action result string.
     * 
     * @param canPerform true if the action can be performed
     * @return formatted result string
     */
    public static String getActionResult(boolean canPerform) {
        return canPerform ? SUCCESS_EMOJI + " Yes" : FAILURE_EMOJI + " No";
    }
}
