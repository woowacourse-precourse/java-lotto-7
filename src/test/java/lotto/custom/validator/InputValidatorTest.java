package lotto.custom.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.custom.common.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    // 구입 금액 유효성 검증 테스트

    @DisplayName("유효성검증_구입금액입력_NULL일때_테스트")
    @Test
    void 유효성검증_구입금액입력_NULL일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_빈문자열일때_테스트")
    @Test
    void 유효성검증_구입금액입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_STRING_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_공백으로구성되어있을때_테스트")
    @Test
    void 유효성검증_구입금액입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_숫자외의문자가있을때_테스트")
    @Test
    void 유효성검증_구입금액입력_숫자외의문자가있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("123#5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INVALID_CHARACTERS_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_int타입의범위를벗어날때_테스트")
    @Test
    void 유효성검증_구입금액입력_int타입의범위를벗어날때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("2147483648")) // Integer.MAX_VALUE + 1
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INT_OUT_OF_BOUNDS);
    }

    @DisplayName("유효성검증_구입금액입력_1000원으로나누어떨어지지않을때_테스트")
    @Test
    void 유효성검증_구입금액입력_1000원으로나누어떨어지지않을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("5400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
    }

    // 당첨 번호 유효성 검증 테스트

    @DisplayName("유효성검증_당첨번호입력_NULL일때_테스트")
    @Test
    void 유효성검증_당첨번호입력_NULL일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("유효성검증_당첨번호입력_빈문자열일때_테스트")
    @Test
    void 유효성검증_당첨번호입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_STRING_INPUT);
    }

    @DisplayName("유효성검증_당첨번호입력_공백으로구성되어있을때_테스트")
    @Test
    void 유효성검증_당첨번호입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY_INPUT);
    }

    @DisplayName("유효성검증_당첨번호입력_숫자쉼표공백을제외한문자가존재할때_테스트")
    @Test
    void 유효성검증_당첨번호입력_숫자쉼표공백을제외한문자가존재할때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersInput("1, 2, 3*4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_CHARACTERS_INPUT);
    }

    @DisplayName("유효성검증_당첨번호입력_숫자와숫자사이에공백이존재할때_테스트")
    @Test
    void 유효성검증_당첨번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbersInput("1, 2, 3, 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.SPACES_BETWEEN_NUMBERS);
    }

    @DisplayName("유효성검증_당첨번호입력_숫자가6개가아닐때_테스트")
    @Test
    void 유효성검증_당첨번호입력_숫자가6개가아닐때_테스트() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> inputValidator.validateLottoNumberCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_COUNT);
    }

    @DisplayName("유효성검증_당첨번호입력_숫자가중복될때_테스트")
    @Test
    void 유효성검증_당첨번호입력_숫자가증복될때_테스트() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> inputValidator.validateUniqueNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE);
    }

    @DisplayName("유효성검증_당첨번호입력_숫자의범위가1에서45가아닐때_테스트")
    @Test
    void 유효성검증_당첨번호입력_숫자의범위가1에서45가아닐때_테스트() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> inputValidator.validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    // 보너스 번호 유효성 검증 테스트

    @DisplayName("유효성검증_보너스번호입력_NULL일때_테스트")
    @Test
    void 유효성검증_보너스번호입력_NULL일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumberInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("유효성검증_보너스번호입력_빈문자열일때_테스트")
    @Test
    void 유효성검증_보너스번호입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_STRING_INPUT);
    }

    @DisplayName("유효성검증_보너스번호입력_공백으로구성되어있을때_테스트")
    @Test
    void 유효성검증_보너스번호입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumberInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY_INPUT);
    }

    @DisplayName("유효성검증_보너스번호입력_숫자와공백을제외한문자가존재할때_테스트")
    @Test
    void 유효성검증_보너스번호입력_숫자와공백을제외한문자가존재할때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumberInput("*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INVALID_CHARACTERS_INPUT);
    }

    @DisplayName("유효성검증_보너스번호입력_숫자와숫자사이에공백이존재할때_테스트") // 고칠 것
    @Test
    void 유효성검증_보너스번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumberInput("1 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.SPACES_BETWEEN_NUMBERS);
    }

    @DisplayName("유효성검증_보너스번호입력_보너스번호와당첨번호가같을때_테스트") // 고칠 것
    @Test
    void 유효성검증_보너스번호입력_보너스번호와당첨번호가같을때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputValidator.validateBonusNumbers(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
    }

    @DisplayName("유효성검증_보너스번호입력_숫자의범위가1에서45가아닐때_테스트") // 고칠 것
    @Test
    void 유효성검증_보너스번호입력_숫자의범위가1에서45가아닐때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputValidator.validateBonusNumbers(winningNumbers, 47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
    }
}