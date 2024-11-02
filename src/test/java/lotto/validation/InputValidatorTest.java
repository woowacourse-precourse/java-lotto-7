package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidatorImpl validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidatorImpl();
    }

    @Test
    public void testValidate() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("500"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("-1000"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1500"));
    }

    @Test
    public void testParseInput() {
        assertEquals(1000, validator.validate("1000"));
    }
}