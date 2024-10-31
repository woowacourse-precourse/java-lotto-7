package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("입력값 검증 객체 테스트")
class InputValidatorTest {

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지는 자연수인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000"})
    void shouldNotThrowException_WhenAmountIsDivisibleByThousand(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertDoesNotThrow(() -> inputValidator.validateRawInputPurchaseAmount(purchaseAmount));
    }

    @DisplayName("당첨 번호가 올바른 입력인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15"})
    void shouldNotThrowException_WhenWinningNumbersAreValid(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertDoesNotThrow(() -> inputValidator.validateRawInputWinningNumbers(winningNumbers));
    }

    @DisplayName("보너스 번호가 올바른 입력인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"45"})
    void shouldNotThrowException_WhenBonusNumberIsValid(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertDoesNotThrow(() -> inputValidator.validateRawInputBonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가", ""})
    void shouldThrowException_WhenPurchaseAmountIsNotNumeric(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void shouldThrowException_WhenPurchaseAmountLessThan0(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1001"})
    void shouldThrowException_WhenAmountNotDivisibleByThousand(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표와 자연수 외의 문자가 포함된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,가", "1-2-3-4-5-6"})
    void shouldThrowException_WhenWinningNumbersContainsInvalidCharacter(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,가", "1-2-3-4-5-6"})
    void shouldThrowException_WhenWinningNumbersCountIsNot6(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 로또 번호의 범위를 벗어난 번호가 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    void shouldThrowException_WhenWinningNumbersContainOutOfRange(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5"})
    void shouldThrowException_WhenWinningNumbersDuplicate(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력하지 않은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void shouldThrowException_WhenBonusNumberIsEmpty(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가"})
    void shouldThrowException_WhenBonusNumberIsNotNumeric(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void shouldThrowException_WhenBonusNumberIsOutOfRange(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void shouldThrowException_WhenBonusNumberIsDuplicate(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateRawInputBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}