package lotto.model.error;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.error.InputError;
import lotto.error.InputValidator;
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
        assertDoesNotThrow(() -> inputValidator.validatePurchaseAmount(purchaseAmount));
    }

    @DisplayName("당첨 번호가 올바른 입력인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15"})
    void shouldNotThrowException_WhenWinningNumbersAreValid(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertDoesNotThrow(() -> inputValidator.validateWinningNumbers(winningNumbers));
    }

    @DisplayName("보너스 번호가 올바른 입력인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"45"})
    void shouldNotThrowException_WhenBonusNumberIsValid(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertDoesNotThrow(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("구입금액을 입력하지 않은 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void shouldThrowException_WhenPurchaseAmountIsEmpty(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.PURCHASE_AMOUNT_EMPTY.getMessage());
    }

    @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가"})
    void shouldThrowException_WhenPurchaseAmountIsNotNumeric(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.PURCHASE_AMOUNT_INVALID.getMessage());
    }

    @DisplayName("구입금액이 최소 구입금액보다 작은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "999"})
    void shouldThrowException_WhenPurchaseAmountLessBaseAmount(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.PURCHASE_AMOUNT_UNDER_BASE_LIMIT.getMessage());
    }

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "1234"})
    void shouldThrowException_WhenAmountNotDivisibleByThousand(String purchaseAmount) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.PURCHASE_AMOUNT_UNIT_INVALID.getMessage());
    }

    @DisplayName("당첨 번호에 쉼표와 자연수 외의 문자가 포함된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,가", "1-2-3-4-5-6"})
    void shouldThrowException_WhenWinningNumbersContainsInvalidCharacter(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.WINNING_NUMBERS_INVALID.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "39,40,41,42,43,44,45"})
    void shouldThrowException_WhenWinningNumbersCountIsNot6(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.WINNING_NUMBERS_COUNT.getMessage());
    }

    @DisplayName("당첨 번호에 로또 번호의 범위를 벗어난 번호가 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    void shouldThrowException_WhenWinningNumbersContainOutOfRange(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5"})
    void shouldThrowException_WhenWinningNumbersDuplicate(String winningNumbers) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.WINNING_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("보너스 번호를 입력하지 않은 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void shouldThrowException_WhenBonusNumberIsEmpty(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.BONUS_NUMBER_EMPTY.getMessage());
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가"})
    void shouldThrowException_WhenBonusNumberIsNotNumeric(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.LOTTO_NUMBER_INVALID.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void shouldThrowException_WhenBonusNumberIsOutOfRange(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void shouldThrowException_WhenBonusNumberIsDuplicate(String bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
