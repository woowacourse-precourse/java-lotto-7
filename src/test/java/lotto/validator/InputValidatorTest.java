package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외 발생")
    void 구입_금액_댠위_테스트() {
        // given
        String invalidPurchaseAmount = "1200";

        // when & then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구입 금액, 보너스 번호, 당첨 번호가 공백 또는 null인 경우 예외 발생")
    void 공백_또는_null_테스트() {
        // given
        List<Consumer<String>> validators = Arrays.asList(
                InputValidator::validatePurchaseAmount,
                InputValidator::validateWinningNumbers,
                InputValidator::validateBonusNumber
        );

        List<String> invalidInputs = Arrays.asList("", null);

        // when & then
        validators.forEach(validator ->
                invalidInputs.forEach(input ->
                        assertThatThrownBy(() -> validator.accept(input))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage(ExceptionMessage.EMPTY_INPUT.getMessage())
                )
        );
    }

    @Test
    @DisplayName("당첨 번호가 1-45 사이의 숫자가 아닌 경우 예외 발생")
    void 당첨_번호_범위_테스트() {
        // given
        String winningNumbers = "1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 발생")
    void 당첨_번호_6개인지_테스트() {
        // given
        String winningNumbers = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1-45 사이의 숫자가 아닌 경우 예외 발생")
    void 보너스_번호_범위_테스트() {
        // given
        String bonusNumber = "46";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외 발생")
    void 보너스_번호_중복_테스트() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "1";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
