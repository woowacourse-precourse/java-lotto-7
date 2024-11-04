package lotto.view;

import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.OUT_OF_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberInputTest {
    private BonusNumberInput bonusNumberInput;

    @BeforeEach
    void setUp() {
        bonusNumberInput = new BonusNumberInput();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "45"})
    void 올바른_번호_입력시_정상_동작(String input) {
        assertThatCode(() -> bonusNumberInput.validate(input)).doesNotThrowAnyException();
    }

    private void throwException(String input, String message) {
        assertThatThrownBy(() -> bonusNumberInput.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 빈_번호_입력시_예외_발생(String input) {
        throwException(input, EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", " ", " 1", "1 ", " 1 ", "a"})
    void 숫자_아닌_값_입력시_예외_발생(String input) {
        throwException(input, NONE_NUMERIC_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 로또_범위_밖의_값_입력시_예외_발생(String input) {
        throwException(input, OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
    }
}
