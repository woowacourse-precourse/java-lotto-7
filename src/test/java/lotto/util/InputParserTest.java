package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.message.InputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("입력값 파싱 객체 테스트")
class InputParserTest {

    @DisplayName("구입금액 입력값을 정수로 바꿀 수 있는 경우 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "구입금액 입력값: {0}")
    @ValueSource(strings = {"1000", "8000"})
    void shouldNotThrowException_WhenAmountIsNumeric(String purchaseAmount) {
        assertDoesNotThrow(() -> InputParser.validateAndParsePurchaseAmount(purchaseAmount));
    }

    @DisplayName("당첨 번호 입력값을 정수형 리스트로 바꿀 수 있는 경우 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "당첨 번호 입력값: {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15"})
    void shouldNotThrowException_WhenWinningNumbersAreValid(String winningNumbers) {
        assertDoesNotThrow(() -> InputParser.validateAndParseWinningNumbers(winningNumbers));
    }

    @DisplayName("보너스 번호 입력값을 정수로 바꿀 수 있는 경우 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "보너스 번호 입력값: {0}")
    @ValueSource(strings = {"1", "45"})
    void shouldNotThrowException_WhenBonusNumberIsValid(String bonusNumber) {
        assertDoesNotThrow(() -> InputParser.validateAndParseBonusNumber(bonusNumber));
    }

    @DisplayName("구입금액을 입력하지 않은 경우 예외가 발생한다.")
    @ParameterizedTest(name = "구입금액 입력값: {0}")
    @ValueSource(strings = {""})
    void shouldThrowException_WhenPurchaseAmountIsEmpty(String purchaseAmount) {
        assertThatThrownBy(() -> InputParser.validateAndParsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.PURCHASE_AMOUNT_EMPTY.get());
    }

    @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest(name = "구입금액 입력값: {0}")
    @ValueSource(strings = {"a", "가"})
    void shouldThrowException_WhenPurchaseAmountIsNotNumeric(String purchaseAmount) {
        assertThatThrownBy(() -> InputParser.validateAndParsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.PURCHASE_AMOUNT_INVALID.get());
    }

    @DisplayName("당첨 번호에 쉼표와 자연수 외의 문자가 포함된 경우 예외가 발생한다.")
    @ParameterizedTest(name = "당첨 번호 입력값: {0}")
    @ValueSource(strings = {"1,2,3,4,5,가", "1-2-3-4-5-6"})
    void shouldThrowException_WhenWinningNumbersContainsInvalidCharacter(String winningNumbers) {
        assertThatThrownBy(() -> InputParser.validateAndParseWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.WINNING_NUMBERS_INVALID.get());
    }

    @DisplayName("보너스 번호를 입력하지 않은 경우 예외가 발생한다.")
    @ParameterizedTest(name = "보너스 번호 입력값: {0}")
    @ValueSource(strings = {""})
    void shouldThrowException_WhenBonusNumberIsEmpty(String bonusNumber) {
        assertThatThrownBy(() -> InputParser.validateAndParseBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.BONUS_NUMBER_EMPTY.get());
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest(name = "보너스 번호 입력값: {0}")
    @ValueSource(strings = {"a", "가"})
    void shouldThrowException_WhenBonusNumberIsNotNumeric(String bonusNumber) {
        assertThatThrownBy(() -> InputParser.validateAndParseBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.BONUS_NUMBER_INVALID.get());
    }
}
