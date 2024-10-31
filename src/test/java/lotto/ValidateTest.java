package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ValidateTest {
    @Test
    void shouldTrueWhenListHasNoDuplication() {
        assertTrue(Validation.validateNoDuplication(List.of(1,2,3,4,5,6)));
    }

    @Test
    void shouldFalseWhenListHasDuplication() {
        assertFalse(Validation.validateNoDuplication(List.of(1,1,3,4,5,6)));
    }
}
