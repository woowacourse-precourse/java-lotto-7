package lotto.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberParserTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void parseNotLongTest() {
        String notLong = "1000j";
        assertThatThrownBy(() -> NumberParser.parseLong(notLong))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void parseNotIntegerTest() {
        String notInteger = "1000j";
        assertThatThrownBy(() -> NumberParser.parseInteger(notInteger))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}