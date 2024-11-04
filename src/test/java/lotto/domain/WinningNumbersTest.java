package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 번호 생성 및 값 확인 테스트")
    void createWinningNumbers() {
        String input = "1,2,3,4,5,6";

        WinningNumbers winningNumbers = WinningNumbers.from(input);

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, winningNumbers.getWinningNumbers(), "당첨 번호가 예상과 일치해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 발생")
    void validateWinningNumbersSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> WinningNumbers.from("1,2,3,4,5"));
        assertEquals("당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 1~45 범위를 벗어나는 숫자가 포함된 경우 예외 발생")
    void validateWinningNumbersRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> WinningNumbers.from("1,2,3,4,5,46"));
        assertEquals("숫자는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외 발생")
    void validateWinningNumbersDuplicates() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> WinningNumbers.from("1,2,3,4,5,5"));
        assertEquals("중복된 숫자가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외 발생")
    void validateWinningNumbersNotNumbric() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> WinningNumbers.from("1,2,3,4,5,j"));
        assertEquals("입력된 값 중 숫자가 아닌 값이 있습니다.", exception.getMessage());
    }
}