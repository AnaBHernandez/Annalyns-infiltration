package com.anabelen.analyzeprisoner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

/**
 * Comprehensive test suite for Annalyn's Infiltration tactics.
 * Tests all possible scenarios and edge cases for the rescue mission.
 */
@DisplayName("Annalyn's Infiltration Tests")
public class AnnalynsInfiltrationTest {

    @Nested
    @DisplayName("Fast Attack Tests")
    class FastAttackTests {

        @Test
        @DisplayName("Should be able to attack when knight is asleep")
        public void testCanFastAttackWhenKnightAsleep() {
            assertTrue(AnnalynsInfiltration.canFastAttack(false), 
                "Fast attack should be possible when the knight is asleep");
        }

        @Test
        @DisplayName("Should not be able to attack when knight is awake")
        public void testCannotFastAttackWhenKnightAwake() {
            assertFalse(AnnalynsInfiltration.canFastAttack(true), 
                "Fast attack should not be possible when the knight is awake");
        }
    }

    @Nested
    @DisplayName("Spy Tests")
    class SpyTests {

        @Test
        @DisplayName("Should be able to spy when knight is awake")
        public void testCanSpyWhenKnightAwake() {
            assertTrue(AnnalynsInfiltration.canSpy(true, false, false), 
                "Should be able to spy when the knight is awake");
        }

        @Test
        @DisplayName("Should be able to spy when archer is awake")
        public void testCanSpyWhenArcherAwake() {
            assertTrue(AnnalynsInfiltration.canSpy(false, true, false), 
                "Should be able to spy when the archer is awake");
        }

        @Test
        @DisplayName("Should be able to spy when prisoner is awake")
        public void testCanSpyWhenPrisonerAwake() {
            assertTrue(AnnalynsInfiltration.canSpy(false, false, true), 
                "Should be able to spy when the prisoner is awake");
        }

        @Test
        @DisplayName("Should be able to spy when multiple people are awake")
        public void testCanSpyWhenMultipleAwake() {
            assertTrue(AnnalynsInfiltration.canSpy(true, true, false), 
                "Should be able to spy when multiple people are awake");
            assertTrue(AnnalynsInfiltration.canSpy(true, false, true), 
                "Should be able to spy when knight and prisoner are awake");
            assertTrue(AnnalynsInfiltration.canSpy(false, true, true), 
                "Should be able to spy when archer and prisoner are awake");
            assertTrue(AnnalynsInfiltration.canSpy(true, true, true), 
                "Should be able to spy when everyone is awake");
        }

        @Test
        @DisplayName("Should not be able to spy when everyone is asleep")
        public void testCannotSpyWhenAllAsleep() {
            assertFalse(AnnalynsInfiltration.canSpy(false, false, false), 
                "Should not be able to spy when everyone is asleep");
        }
    }

    @Nested
    @DisplayName("Signal Prisoner Tests")
    class SignalPrisonerTests {

        @Test
        @DisplayName("Should be able to signal when archer asleep and prisoner awake")
        public void testCanSignalWhenArcherAsleepPrisonerAwake() {
            assertTrue(AnnalynsInfiltration.canSignalPrisoner(false, true), 
                "Should be able to signal when archer is asleep and prisoner is awake");
        }

        @Test
        @DisplayName("Should not be able to signal when archer is awake")
        public void testCannotSignalWhenArcherAwake() {
            assertFalse(AnnalynsInfiltration.canSignalPrisoner(true, true), 
                "Should not be able to signal when archer is awake, even if prisoner is awake");
            assertFalse(AnnalynsInfiltration.canSignalPrisoner(true, false), 
                "Should not be able to signal when archer is awake and prisoner is asleep");
        }

        @Test
        @DisplayName("Should not be able to signal when prisoner is asleep")
        public void testCannotSignalWhenPrisonerAsleep() {
            assertFalse(AnnalynsInfiltration.canSignalPrisoner(false, false), 
                "Should not be able to signal when prisoner is asleep, even if archer is asleep");
        }
    }

    @Nested
    @DisplayName("Free Prisoner Tests")
    class FreePrisonerTests {

        @Nested
        @DisplayName("Without Dog")
        class WithoutDogTests {

            @Test
            @DisplayName("Should be able to free when knight and archer asleep, prisoner awake")
            public void testCanFreeWithoutDogWhenCaptorsAsleepPrisonerAwake() {
                assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, true, false), 
                    "Should be able to free prisoner when knight and archer are asleep and prisoner is awake");
            }

            @Test
            @DisplayName("Should not be able to free when knight is awake")
            public void testCannotFreeWithoutDogWhenKnightAwake() {
                assertFalse(AnnalynsInfiltration.canFreePrisoner(true, false, true, false), 
                    "Should not be able to free prisoner when knight is awake");
            }

            @Test
            @DisplayName("Should not be able to free when archer is awake")
            public void testCannotFreeWithoutDogWhenArcherAwake() {
                assertFalse(AnnalynsInfiltration.canFreePrisoner(false, true, true, false), 
                    "Should not be able to free prisoner when archer is awake");
            }

            @Test
            @DisplayName("Should not be able to free when prisoner is asleep")
            public void testCannotFreeWithoutDogWhenPrisonerAsleep() {
                assertFalse(AnnalynsInfiltration.canFreePrisoner(false, false, false, false), 
                    "Should not be able to free prisoner when prisoner is asleep");
            }

            @Test
            @DisplayName("Should not be able to free when both captors are awake")
            public void testCannotFreeWithoutDogWhenBothCaptorsAwake() {
                assertFalse(AnnalynsInfiltration.canFreePrisoner(true, true, true, false), 
                    "Should not be able to free prisoner when both captors are awake");
            }
        }

        @Nested
        @DisplayName("With Dog")
        class WithDogTests {

            @Test
            @DisplayName("Should be able to free when archer is asleep (with dog)")
            public void testCanFreeWithDogWhenArcherAsleep() {
                assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, true, true), 
                    "Should be able to free prisoner with dog when archer is asleep");
                assertTrue(AnnalynsInfiltration.canFreePrisoner(true, false, true, true), 
                    "Should be able to free prisoner with dog when archer is asleep (knight awake doesn't matter)");
                assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, false, true), 
                    "Should be able to free prisoner with dog when archer is asleep (prisoner asleep doesn't matter)");
            }

            @Test
            @DisplayName("Should not be able to free when archer is awake (with dog)")
            public void testCannotFreeWithDogWhenArcherAwake() {
                assertFalse(AnnalynsInfiltration.canFreePrisoner(false, true, true, true), 
                    "Should not be able to free prisoner with dog when archer is awake");
                assertFalse(AnnalynsInfiltration.canFreePrisoner(true, true, true, true), 
                    "Should not be able to free prisoner with dog when archer is awake");
            }
        }
    }

    @Nested
    @DisplayName("Edge Cases and Complex Scenarios")
    class EdgeCaseTests {

        @Test
        @DisplayName("All awake scenario")
        public void testAllAwakeScenario() {
            // When everyone is awake
            assertFalse(AnnalynsInfiltration.canFastAttack(true), "Cannot fast attack when knight awake");
            assertTrue(AnnalynsInfiltration.canSpy(true, true, true), "Can spy when everyone awake");
            assertFalse(AnnalynsInfiltration.canSignalPrisoner(true, true), "Cannot signal when archer awake");
            assertFalse(AnnalynsInfiltration.canFreePrisoner(true, true, true, false), "Cannot free without dog when captors awake");
            assertFalse(AnnalynsInfiltration.canFreePrisoner(true, true, true, true), "Cannot free with dog when archer awake");
        }

        @Test
        @DisplayName("All asleep scenario")
        public void testAllAsleepScenario() {
            // When everyone is asleep
            assertTrue(AnnalynsInfiltration.canFastAttack(false), "Can fast attack when knight asleep");
            assertFalse(AnnalynsInfiltration.canSpy(false, false, false), "Cannot spy when everyone asleep");
            assertFalse(AnnalynsInfiltration.canSignalPrisoner(false, false), "Cannot signal when prisoner asleep");
            assertFalse(AnnalynsInfiltration.canFreePrisoner(false, false, false, false), "Cannot free without dog when prisoner asleep");
            assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, false, true), "Can free with dog when archer asleep");
        }

        @Test
        @DisplayName("Optimal rescue scenario")
        public void testOptimalRescueScenario() {
            // Best scenario: knight asleep, archer asleep, prisoner awake, dog present
            boolean knightAsleep = false;
            boolean archerAsleep = false;
            boolean prisonerAwake = true;
            boolean dogPresent = true;

            assertTrue(AnnalynsInfiltration.canFastAttack(knightAsleep), "Can fast attack");
            assertTrue(AnnalynsInfiltration.canSpy(knightAsleep, archerAsleep, prisonerAwake), "Can spy");
            assertTrue(AnnalynsInfiltration.canSignalPrisoner(archerAsleep, prisonerAwake), "Can signal");
            assertTrue(AnnalynsInfiltration.canFreePrisoner(knightAsleep, archerAsleep, prisonerAwake, dogPresent), "Can free");
        }
    }
}
