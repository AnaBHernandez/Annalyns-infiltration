package com.anabelen.analyzeprisoner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AnnalynsInfiltrationTest {

    @Test
    public void testCanFastAttack() {
        assertTrue(AnnalynsInfiltration.canFastAttack(false), "Should be able to attack when the knight is asleep");
        assertFalse(AnnalynsInfiltration.canFastAttack(true), "Should not be able to attack when the knight is awake");
    }

    @Test
    public void testCanSpy() {
        assertTrue(AnnalynsInfiltration.canSpy(true, false, false), "Should be able to spy when the knight is awake");
        assertTrue(AnnalynsInfiltration.canSpy(false, true, false), "Should be able to spy when the archer is awake");
        assertTrue(AnnalynsInfiltration.canSpy(false, false, true), "Should be able to spy when the prisoner is awake");
        assertFalse(AnnalynsInfiltration.canSpy(false, false, false), "Should not be able to spy when all are asleep");
    }

    @Test
    public void testCanSignalPrisoner() {
        assertTrue(AnnalynsInfiltration.canSignalPrisoner(false, true), "Should be able to signal the prisoner when the archer is asleep and the prisoner is awake");
        assertFalse(AnnalynsInfiltration.canSignalPrisoner(true, true), "Should not be able to signal when the archer is awake");
        assertFalse(AnnalynsInfiltration.canSignalPrisoner(false, false), "Should not be able to signal when the prisoner is asleep");
    }

    @Test
    public void testCanFreePrisoner() {
        assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, true, false), "Should be able to free the prisoner when the knight and archer are asleep and the prisoner is awake");
        assertFalse(AnnalynsInfiltration.canFreePrisoner(true, false, true, false), "Should not be able to free the prisoner when the knight is awake");
        assertFalse(AnnalynsInfiltration.canFreePrisoner(false, true, true, false), "Should not be able to free the prisoner when the archer is awake");
        assertTrue(AnnalynsInfiltration.canFreePrisoner(false, false, true, true), "Should be able to free the prisoner when the pet dog is present and the archer is asleep");
        assertFalse(AnnalynsInfiltration.canFreePrisoner(false, true, false, true), "Should not be able to free the prisoner when the archer is awake even if the pet dog is present");
    }
}
