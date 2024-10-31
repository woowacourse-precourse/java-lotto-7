package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ValidateTest {
    @Test
    void shouldReturnTrueWhenListHasNoDuplication() {
        assertTrue(Validation.validateNoDuplication(List.of(1,2,3,4,5,6)));
    }

    @Test
    void shouldReturnFalseWhenListHasDuplication() {
        assertFalse(Validation.validateNoDuplication(List.of(1,1,3,4,5,6)));
    }

    @Test
    void shouldReturnTrueWhenInputIsNumeric() {
        assertTrue(Validation.validateNumber("1"));
    }

    @Test
    void shouldReturnFalseWhenInputIsNotNumeric() {
        assertFalse(Validation.validateNumber("a"));
        assertFalse(Validation.validateNumber(""));
        assertFalse(Validation.validateNumber("+"));
    }
}
