package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

class WinningNumberInputTest {

    @Test
    @DisplayName("올바른 당첨 번호 입력 테스트")
    void testValidWinningNumbers() {
        String input = "1, 5, 10, 20, 30, 40";
        List<Integer> winningNumbers = WinningNumberInput.parseAndValidateWinningNumbers(input);

        Assertions.assertEquals(6, winningNumbers.size(), "[ERROR] 당첨 번호는 6개여야 합니다.");
        Assertions.assertTrue(winningNumbers.containsAll(List.of(1, 5, 10, 20, 30, 40)), "[ERROR]  올바른 당첨 번호여야 합니다.");
    }

    @Test
    @DisplayName("잘못된 당첨 번호 입력 테스트 - 숫자가 아닌 값")
    void testInvalidWinningNumbersNonNumeric() {
        String input = "1, 5, 10, A, 30, 40";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberInput.parseAndValidateWinningNumbers(input)
        );
        Assertions.assertEquals("[ERROR] 당첨 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 당첨 번호 입력 테스트 - 6개가 아닌 경우")
    void testInvalidWinningNumbersIncorrectCount() {
        String input = "1, 5, 10, 20, 30";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberInput.parseAndValidateWinningNumbers(input)
        );
        Assertions.assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 당첨 번호 입력 테스트 - 중복된 번호가 있는 경우")
    void testInvalidWinningNumbersDuplicateNumbers() {
        String input = "1, 5, 10, 10, 30, 40";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberInput.parseAndValidateWinningNumbers(input)
        );
        Assertions.assertEquals("[ERROR] 당첨 번호는 중복되지 않아야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 당첨 번호 입력 테스트 - 범위를 벗어난 번호가 있는 경우")
    void testInvalidWinningNumbersOutOfRange() {
        String input = "0, 5, 10, 20, 30, 46";

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningNumberInput.parseAndValidateWinningNumbers(input)
        );
        Assertions.assertEquals("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.", exception.getMessage());
    }
}
