package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

class BonusNumberInputTest {

    @Test
    @DisplayName("올바른 보너스 번호 입력 테스트")
    void testValidBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 5, 10, 20, 30, 40);
        String input = "7";

        int bonusNumber = BonusNumberInput.parseAndValidateBonusNumber(input, winningNumbers);
        Assertions.assertEquals(7, bonusNumber, "올바른 보너스 번호여야 합니다.");
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력 테스트 - 숫자가 아닌 값")
    void testInvalidBonusNumberNonNumeric() {
        List<Integer> winningNumbers = List.of(1, 5, 10, 20, 30, 40);
        String input = "A";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberInput.parseAndValidateBonusNumber(input, winningNumbers)
        );
        Assertions.assertEquals("[ERROR] 보너스 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력 테스트 - 범위를 벗어난 번호")
    void testInvalidBonusNumberOutOfRange() {
        List<Integer> winningNumbers = List.of(1, 5, 10, 20, 30, 40);
        String input = "50";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberInput.parseAndValidateBonusNumber(input, winningNumbers)
        );
        Assertions.assertEquals("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력 테스트 - 당첨 번호와 중복되는 경우")
    void testInvalidBonusNumberDuplicateWithWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 5, 10, 20, 30, 40);
        String input = "10";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberInput.parseAndValidateBonusNumber(input, winningNumbers)
        );
        Assertions.assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }
}