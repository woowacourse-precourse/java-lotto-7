package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberInputConverterTest {
    @DisplayName("숫자가 아니면 [ERROR]로 시작하는 illegalArgumentException 반환")
    @ParameterizedTest
    @CsvSource({"''", "' '", "','"})
    void testToIntThrowIllegalArgumentExceptionWhenInvalidString(String invalidInput) {
        NumberInputConverter numberInputConverter = NumberInputConverter.getInstance();
        assertThatThrownBy(() -> numberInputConverter.toInt(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }

    @DisplayName("숫자가 아니면 [ERROR]로 시작하는 illegalArgumentException 반환")
    @ParameterizedTest
    @CsvSource({
            "',2'",
            "'1,2, ,4'",
            "'1,2,,4'",
            "'1,2,3,'",
            "''"
    })
    void testToListThrowIllegalArgumentExceptionWhenInvalidString(String invalidInput) {
        NumberInputConverter numberInputConverter = NumberInputConverter.getInstance();
        assertThatThrownBy(() -> numberInputConverter.toList(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }
}