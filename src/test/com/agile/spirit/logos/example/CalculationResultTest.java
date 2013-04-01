package com.agile.spirit.logos.example;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

import com.agile.spirit.logos.example.CalculationResult;
import com.agile.spirit.logos.example.Outcome;

public class CalculationResultTest {

    @Test
    public void testAddNull() {
        // Given
        CalculationResult r1 = CalculationResult.create(Outcome.REJECTED, BigDecimal.ZERO);

        // When
        CalculationResult r2 = r1.add(null);

        // Then
        Assert.assertEquals(Outcome.REJECTED, r2.getOutcome());
    }

    @Test
    public void testAddRejected() {
        // Given
        CalculationResult r1 = CalculationResult.create(Outcome.REJECTED, BigDecimal.ZERO);
        CalculationResult r2 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);

        // When
        CalculationResult r3 = r1.add(r2);
        CalculationResult r4 = r2.add(r1);

        // Then
        Assert.assertEquals(Outcome.REJECTED, r3.getOutcome());
        Assert.assertEquals(Outcome.REJECTED, r4.getOutcome());
    }

    @Test
    public void testAddPended() {
        // Given
        CalculationResult r1 = CalculationResult.create(Outcome.PENDED, BigDecimal.ZERO);
        CalculationResult r2 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);

        // When
        CalculationResult r3 = r1.add(r2);
        CalculationResult r4 = r2.add(r1);

        // Then
        Assert.assertEquals(Outcome.PENDED, r3.getOutcome());
        Assert.assertEquals(Outcome.PENDED, r4.getOutcome());
    }

    @Test
    public void testAddAcceptedWithoutMajoration() {
        // Given
        CalculationResult r1 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);
        CalculationResult r2 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);

        // When
        CalculationResult r3 = r1.add(r2);
        CalculationResult r4 = r2.add(r1);

        // Then
        Assert.assertEquals(Outcome.ACCEPTED, r3.getOutcome());
        Assert.assertEquals(Outcome.ACCEPTED, r4.getOutcome());
    }

    @Test
    public void testAddAcceptedWithMajoration() {
        // Given
        CalculationResult r1 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);
        CalculationResult r2 = CalculationResult.create(Outcome.ACCEPTED, BigDecimal.ZERO);

        // When
        CalculationResult r3 = r1.add(r2);
        CalculationResult r4 = r2.add(r1);

        // Then
        Assert.assertEquals(Outcome.ACCEPTED, r3.getOutcome());
        Assert.assertEquals(Outcome.ACCEPTED, r4.getOutcome());
    }

}
