package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberInputConverterTest {
    @DisplayName("문자가 없으면 illegalArgumentException 반환")
    @ParameterizedTest
    @CsvSource({"''", "' '", "','"})
    void testToIntThrowIllegalArgumentExceptionWhenInvalidString(String invalidInput) {
        NumberInputConverter numberInputConverter = NumberInputConverter.getInstance();
        assertThatThrownBy(() -> numberInputConverter.toInt(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자로만 구성된 문자가 아니면 illegalArgumentException 반환")
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
                .isInstanceOf(IllegalArgumentException.class);
    }
}