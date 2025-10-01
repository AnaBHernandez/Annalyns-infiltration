package com.anabelen.analyzeprisoner;

/**
 * Represents the current state of Annalyn's infiltration game.
 * Encapsulates all character states and provides methods to query game state.
 * 
 * @author Ana Belén Hernández
 * @version 1.0
 * @since 2024
 */
public class GameState {
    
    private final boolean knightIsAwake;
    private final boolean archerIsAwake;
    private final boolean prisonerIsAwake;
    private final boolean petDogIsPresent;
    
    /**
     * Creates a new game state with the specified character states.
     * 
     * @param knightIsAwake true if the knight is awake
     * @param archerIsAwake true if the archer is awake
     * @param prisonerIsAwake true if the prisoner is awake
     * @param petDogIsPresent true if Annalyn has her dog
     */
    public GameState(boolean knightIsAwake, boolean archerIsAwake, 
                    boolean prisonerIsAwake, boolean petDogIsPresent) {
        this.knightIsAwake = knightIsAwake;
        this.archerIsAwake = archerIsAwake;
        this.prisonerIsAwake = prisonerIsAwake;
        this.petDogIsPresent = petDogIsPresent;
    }
    
    /**
     * Gets the knight's awake state.
     * 
     * @return true if the knight is awake
     */
    public boolean isKnightAwake() {
        return knightIsAwake;
    }
    
    /**
     * Gets the archer's awake state.
     * 
     * @return true if the archer is awake
     */
    public boolean isArcherAwake() {
        return archerIsAwake;
    }
    
    /**
     * Gets the prisoner's awake state.
     * 
     * @return true if the prisoner is awake
     */
    public boolean isPrisonerAwake() {
        return prisonerIsAwake;
    }
    
    /**
     * Gets the dog's presence state.
     * 
     * @return true if the dog is present
     */
    public boolean isPetDogPresent() {
        return petDogIsPresent;
    }
    
    /**
     * Checks if any character is awake.
     * 
     * @return true if at least one character is awake
     */
    public boolean isAnyoneAwake() {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }
    
    /**
     * Checks if all captors (knight and archer) are asleep.
     * 
     * @return true if both knight and archer are asleep
     */
    public boolean areCaptorsAsleep() {
        return !knightIsAwake && !archerIsAwake;
    }
    
    /**
     * Checks if the optimal rescue conditions are met.
     * Optimal conditions: knight asleep, archer asleep, prisoner awake, dog present.
     * 
     * @return true if all optimal conditions are met
     */
    public boolean isOptimalRescueCondition() {
        return !knightIsAwake && !archerIsAwake && prisonerIsAwake && petDogIsPresent;
    }
    
    /**
     * Gets a formatted string representation of the current game state.
     * 
     * @return formatted game state string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 Current Game State:\n");
        sb.append("   ").append(GameConstants.KNIGHT).append(": ")
          .append(GameConstants.getCharacterStatus(knightIsAwake)).append("\n");
        sb.append("   ").append(GameConstants.ARCHER).append(": ")
          .append(GameConstants.getCharacterStatus(archerIsAwake)).append("\n");
        sb.append("   ").append(GameConstants.PRISONER).append(": ")
          .append(GameConstants.getCharacterStatus(prisonerIsAwake)).append("\n");
        sb.append("   ").append(GameConstants.DOG).append(": ")
          .append(GameConstants.getDogStatus(petDogIsPresent));
        return sb.toString();
    }
    
    /**
     * Creates a copy of this game state with the specified changes.
     * 
     * @param knightIsAwake new knight state (null to keep current)
     * @param archerIsAwake new archer state (null to keep current)
     * @param prisonerIsAwake new prisoner state (null to keep current)
     * @param petDogIsPresent new dog state (null to keep current)
     * @return new GameState with specified changes
     */
    public GameState withChanges(Boolean knightIsAwake, Boolean archerIsAwake, 
                               Boolean prisonerIsAwake, Boolean petDogIsPresent) {
        return new GameState(
            knightIsAwake != null ? knightIsAwake : this.knightIsAwake,
            archerIsAwake != null ? archerIsAwake : this.archerIsAwake,
            prisonerIsAwake != null ? prisonerIsAwake : this.prisonerIsAwake,
            petDogIsPresent != null ? petDogIsPresent : this.petDogIsPresent
        );
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        GameState gameState = (GameState) obj;
        return knightIsAwake == gameState.knightIsAwake &&
               archerIsAwake == gameState.archerIsAwake &&
               prisonerIsAwake == gameState.prisonerIsAwake &&
               petDogIsPresent == gameState.petDogIsPresent;
    }
    
    @Override
    public int hashCode() {
        int result = Boolean.hashCode(knightIsAwake);
        result = 31 * result + Boolean.hashCode(archerIsAwake);
        result = 31 * result + Boolean.hashCode(prisonerIsAwake);
        result = 31 * result + Boolean.hashCode(petDogIsPresent);
        return result;
    }
}
