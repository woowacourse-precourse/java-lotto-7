package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidator.validateLottoNumber(input);
        });
    }

    @DisplayName("구분자가 쉼표(,)가 아니면 예외가 발생한다.")
    @Test
    void validateNotComma() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidator.validateLottoNumber("1 2 3 4 5 7");
        });
    }

    @DisplayName("쉼표(,)가 2개 이상 연속적으로 입력되면 예외가 발생한다.")
    @Test
    void validateSeparatorContinue() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidator.validateLottoNumber("1,2,3,4,5,,,7");
        });
    }

    @DisplayName("쉼표(,) 사이에 공백이 있을 경우 연속적으로 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3, ,5,,,7", "1,2,3,   ,5,,,7"})
    void validateNoEmptyBetweenCommas(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidator.validateLottoNumber(input);
        });
    }

    @DisplayName("6개의 숫자를 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validateNotSixNumbers(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidator.validateLottoNumber(input);
        });
    }
}