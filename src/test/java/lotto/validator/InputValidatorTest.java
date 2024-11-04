package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("구매 금액을 공백을 입력했을 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void 구입_금액이_공백일_경우_예외가_발생한다(String rawMoney) {
        assertThatThrownBy(() -> inputValidator.validateBlank(rawMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_IS_NOT_BLANK.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 양의 정수가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "0", "-2"})
    void 구입_금액이_양의_정수가_아니면_예외가_발생한다(String rawMoney) {
        assertThatThrownBy(() -> inputValidator.validateMoneyFormat(rawMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_MONEY_IS_DIGIT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 0보다 큰 정수가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "-2"})
    void 보너스_번호가_0이상_9이하의_정수가_아닐_경우_예외가_발생한다(String rawNumber) {
        assertThatThrownBy(() -> inputValidator.validateLottoNumber(rawNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
    }
}