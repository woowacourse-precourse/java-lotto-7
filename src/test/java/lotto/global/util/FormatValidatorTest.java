package lotto.global.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormatValidatorTest {
    static FormatValidator formatValidator;

    @BeforeAll
    static void setUp() {
        formatValidator = FormatValidator.getInstance();
    }

    @DisplayName("1000원 단위의 숫자를 입력받지 않으면 에러 발생")
    @ParameterizedTest
    @CsvSource({"100", "price"})
    void validatePriceFormat(String price) {
        assertThatThrownBy(() -> formatValidator.validatePriceFormat(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자와 쉼표 외의 값을 포함해 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource({"1 2 3 4 5 6", "numbers", "1-2-3-4-5-6"})
    void validateWinningNumberFormat(String numbers) {
        assertThatThrownBy(() -> formatValidator.validateWinningNumberFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 외의 값을 포함해 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource({"a", "-5"})
    void validateBonusNumberFormat(String number) {
        assertThatThrownBy(() -> formatValidator.validateBonusNumberFormat(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}