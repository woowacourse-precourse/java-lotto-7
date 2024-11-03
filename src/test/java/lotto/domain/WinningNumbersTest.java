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
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());
    }
}