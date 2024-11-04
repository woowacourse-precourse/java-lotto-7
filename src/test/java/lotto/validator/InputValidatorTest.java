package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("유효한 구입 금액 입력 테스트")
    void testValidPurchaseAmount() {
        assertEquals(1000, PurchaseValidator.validatePurchaseAmount("1000"));
    }

    @Test
    @DisplayName("구입 금액 숫자가 아닐 때 예외 테스트")
    void testInvalidPurchaseAmountNonInteger() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseValidator.validatePurchaseAmount("abcd")
        );
        assertEquals("[ERROR] 구입금액은 정수여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 테스트")
    void testInvalidPurchaseAmountNotMultipleOfThousand() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseValidator.validatePurchaseAmount("1500")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 0 이하일 때 예외 테스트")
    void testInvalidPurchaseAmountNegativeOrZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseValidator.validatePurchaseAmount("0")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야 합니다.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseValidator.validatePurchaseAmount("-1000")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유효한 당첨 번호 입력 테스트")
    void testValidWinningNumbers() {
        List<Integer> validWinningNumbers = WinningNumberValidator.validateWinningNumbers(
                List.of("1", "2", "3", "4", "5", "6"));
        assertEquals(List.of(1, 2, 3, 4, 5, 6), validWinningNumbers);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아닐 때 예외 테스트")
    void testInvalidWinningNumbersNonInteger() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberValidator.validateWinningNumbers(List.of("1", "2", "a", "4", "5", "6"))
        );
        assertEquals("[ERROR] 로또 번호는 정수여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 테스트")
    void testInvalidWinningNumbersCount() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberValidator.validateWinningNumbers(List.of("1", "2", "3", "4", "5"))
        );
        assertEquals("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 1부터 45 범위를 벗어날 경우 예외 테스트")
    void testInvalidWinningNumbersRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberValidator.validateWinningNumbers(List.of("0", "2", "3", "4", "5", "6"))
        );
        assertEquals("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberValidator.validateWinningNumbers(List.of("1", "2", "3", "4", "5", "46"))
        );
        assertEquals("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외 테스트")
    void testDuplicateWinningNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberValidator.validateWinningNumbers(List.of("1", "2", "3", "4", "5", "5"))
        );
        assertEquals("[ERROR] 당첨 번호는 중복되지 않아야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유효한 보너스 번호 입력 테스트")
    void testValidBonusNumber() {
        int validBonusNumber = BonusNumberValidator.validateBonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
        assertEquals(7, validBonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 때 예외 테스트")
    void testInvalidBonusNumberNonInteger() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber("a", List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals("[ERROR] 보너스 번호는 정수여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 범위를 벗어날 경우 예외 테스트")
    void testInvalidBonusNumberRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber("0", List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber("46", List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 테스트")
    void testDuplicateBonusNumberWithWinningNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber("5", List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.", exception.getMessage());
    }
}