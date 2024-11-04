package lotto;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("빈 금액 입력하면 EMPTY_PURCHASE_PRICE 에러가 발생해야 한다.")
    void validatePurchasePrice_withEmptyInput_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validatePurchasePrice(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_PURCHASE_PRICE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    @DisplayName("0 이하의 금액을 입력하면 INVALID_PURCHASE_PRICE 에러가 발생해야 한다.")
    void validatePurchasePrice_withZeroOrNegativeInput_shouldThrowException(String input) {
        assertThatThrownBy(() -> inputValidator.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 금액을 입력하면 INVALID_PURCHASE_PRICE 에러가 발생해야 한다.")
    void validatePurchasePrice_withNonIntegerValue_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validatePurchasePrice("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 비어있으면 EMPTY_WINNING_NUMBERS 에러가 발생해야 한다.")
    void validateWinningNumbers_withEmptyInput_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_WINNING_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 INVALID_WINNING_NUMBERS_COUNT 에러가 발생해야 한다.")
    void validateWinningNumbers_withIncorrectCount_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
    }

    @Test
    @DisplayName("중복된 당첨 번호가 있을 경우 DUPLICATE_WINNING_NUMBERS 에러가 발생해야 한다.")
    void validateWinningNumbers_withDuplicateNumbers_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 범위를 벗어날 경우 INVALID_WINNING_NUMBER_RANGE 에러가 발생해야 한다.")
    void validateWinningNumbers_withOutOfRangeNumber_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 비어있으면 EMPTY_BONUS_NUMBER 에러가 발생해야 한다.")
    void validateBonusNumber_withEmptyInput_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어날 경우 INVALID_BONUS_NUMBER_RANGE 에러가 발생해야 한다.")
    void validateBonusNumber_withOutOfRangeInput_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 BONUS_NUMBER_DUPLICATE 에러가 발생해야 한다.")
    void validateBonusNumber_withDuplicateBonusNumber_shouldThrowException() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
    }
}