package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BonusNumberTest {
    private final WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외 발생")
    void validateBonusNumberIsNumeric() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BonusNumber.from(("abc"), winningNumbers));
        assertEquals("보너스 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나는 경우 예외 발생")
    void validateBonusNumberInRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BonusNumber.from("46", winningNumbers));
        assertEquals("보너스 번호는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    void validateBonusNumberNotInWinningNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BonusNumber.from("3", winningNumbers));
        assertEquals("보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("올바른 보너스 번호로 BonusNumber 객체 생성")
    void createBonusNumberWithValidInput() {
        BonusNumber bonusNumber = BonusNumber.from("7", winningNumbers);
        assertEquals("7", bonusNumber.getBonusNumber());
    }
}