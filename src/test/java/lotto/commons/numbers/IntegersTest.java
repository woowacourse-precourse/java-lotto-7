package lotto.commons.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegersTest {

    @Test
    void parseIntOrThrow_should_be_pass() {
        // given
        // when
        String value = "1234";
        Integer number = Integers.parseIntOrThrow(value, "숫자가 아닙니다.");
        // then
        Assertions.assertEquals(1234, number);
    }

    @Test
    void parseIntOrThrow_when_value_is_nan_should_be_fail() {
        // given
        // when
        String value = "nan";
        // then
        Exception ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Integers.parseIntOrThrow(value, "숫자가 아닙니다.")
        );
        Assertions.assertEquals("숫자가 아닙니다.", ex.getMessage());
    }
}
