package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("구매 금액이 1000원 미만일 때 예외 발생")
    void testValidatePurchaseAmountBelowMinimum() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validatePurchaseAmount("500"));
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외 발생")
    void testValidatePurchaseAmountNotDivisibleByThousand() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validatePurchaseAmount("1500"));
    }

    @Test
    @DisplayName("구매 금액이 null일 때 예외 발생")
    void testValidatePurchaseAmountNull() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validatePurchaseAmount(null));
    }

    @Test
    @DisplayName("구매 금액이 숫자가 아닐 때 예외 발생")
    void testValidatePurchaseAmountNotANumber() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validatePurchaseAmount("one thousand"));
    }

    @Test
    @DisplayName("당첨 번호가 1에서 45 사이가 아닐 때 예외 발생")
    void testValidateWinningNumbersOutOfRange() {
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateWinningNumbers(invalidWinningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아닐 때 예외 발생")
    void testValidateBonusNumberOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateBonusNumber(50));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복될 때 예외 발생")
    void testValidateWinningNumbersBonusNumberOverlap() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateNoOverlap(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호가 null일 때 예외 발생")
    void testValidateWinningNumbersNull() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateWinningNumbers(null));
    }

    @Test
    @DisplayName("당첨 번호에 구분자를 제외한 문자가 있을 때 예외 발생")
    void testValidateWinningNumbersStringWithInvalidCharacters() {
        String invalidWinningNumbers = "1, 2, a, 4, 5, 6";
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateWinningNumbersString(invalidWinningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 null일 때 예외 발생")
    void testValidateBonusNumberNull() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateBonusNumberString(null));
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 때 예외 발생")
    void testValidateBonusNumberNotANumber() {
        String invalidBonusNumber = "seven";
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateBonusNumberString(invalidBonusNumber));
    }
}