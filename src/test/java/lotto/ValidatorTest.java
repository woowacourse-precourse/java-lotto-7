package lotto.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void 구매금액검증_유효한입력() {
        assertDoesNotThrow(() -> Validator.checkPurchaseAmount("10000"));
    }

    @Test
    public void 구매금액검증_빈입력() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkPurchaseAmount(""));
        assertEquals("구매 금액을 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 구매금액검증_음수금액() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkPurchaseAmount("-1000"));
        assertEquals("구매 금액은 0원 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    public void 당첨번호검증_유효한입력() {
        String[] validNumbers = {"1", "2", "3", "4", "5", "6"};
        assertDoesNotThrow(() -> Validator.checkWinningLottoNumbers(validNumbers, "6개의 당첨 번호를 입력해야 합니다."));
    }

    @Test
    public void 당첨번호검증_길이검증실패() {
        String[] invalidNumbers = {"1", "2", "3"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkWinningLottoNumbers(invalidNumbers, "6개의 당첨 번호를 입력해야 합니다."));
        assertEquals("6개의 당첨 번호를 입력해야 합니다.", exception.getMessage());
    }

    @Test
    public void 당첨번호검증_비숫자입력() {
        String[] invalidNumbers = {"1", "2", "3", "a", "5", "6"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkWinningLottoNumbers(invalidNumbers, "6개의 당첨 번호를 입력해야 합니다."));
        assertEquals("잘못된 번호가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    public void 보너스번호검증_유효한입력() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        assertDoesNotThrow(() -> Validator.checkBonusNumber("7", winningNumbers, "보너스 번호를 입력해주세요."));
    }

    @Test
    public void 보너스번호검증_빈입력() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkBonusNumber("", winningNumbers, "보너스 번호를 입력해주세요."));
        assertEquals("보너스 번호를 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 보너스번호검증_비숫자입력() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkBonusNumber("a", winningNumbers, "보너스 번호를 입력해주세요."));
        assertEquals("보너스 번호를 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 보너스번호검증_중복번호() {
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkBonusNumber("1", winningNumbers, "보너스 번호를 입력해주세요."));
        assertEquals("보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }
}
