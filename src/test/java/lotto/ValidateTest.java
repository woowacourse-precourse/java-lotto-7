package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ValidateTest {
    @Test
    void shouldReturnTrueWhenListHasNoDuplication() {
        assertTrue(Validation.isUnique(List.of(1,2,3,4,5,6)));
    }

    @Test
    void shouldReturnFalseWhenListHasDuplication() {
        assertFalse(Validation.isUnique(List.of(1,1,3,4,5,6)));
    }

    @Test
    void shouldReturnTrueWhenInputIsNumeric() {
        assertTrue(Validation.isNumeric("1"));
    }

    @Test
    void shouldReturnFalseWhenInputIsNotNumeric() {
        assertFalse(Validation.isNumeric("a"));
        assertFalse(Validation.isNumeric(""));
        assertFalse(Validation.isNumeric("+"));
    }

    @Test
    void shouldReturnTrueWhenInputIsEmpty() {
        assertTrue(Validation.isEmptyInput(""));
    }

    @Test
    void shouldReturnFalseWhenInputIsNotEmpty() {
        assertFalse(Validation.isEmptyInput("1"));
    }

    @Test
    void shouldReturnTrueWhenNumbersAreInRange() {
        assertTrue(Validation.isInRange1To45(List.of(1,2,3,4,5,6)));
    }

    @Test
    void shouldReturnFalseWhenNumbersAreNotInRange() {
        assertFalse(Validation.isInRange1To45(List.of(0,2,3,4,5,6)));
        assertFalse(Validation.isInRange1To45(List.of(1,2,3,4,5,46)));
    }

    @Test
    void shouldReturnTrueWhenWinningNumberIsValid() {
        assertTrue(Validation.isValidWinningNumber("1,2,3,4,5,6"));
        assertTrue(Validation.isValidWinningNumber("41,42,43,64,85,126"));
    }

    @Test
    void shouldReturnFalseWhenWinningNumberIsInvalid() {
        assertFalse(Validation.isValidWinningNumber("1,2,a,4,5,6"));
        assertFalse(Validation.isValidWinningNumber("41,42,43,64,85,"));
        assertFalse(Validation.isValidWinningNumber(",42,43,64,85,1"));
        assertFalse(Validation.isValidWinningNumber("41,42,,64,85,5"));
        assertFalse(Validation.isValidWinningNumber("41,42,4,64,5"));
    }
}
