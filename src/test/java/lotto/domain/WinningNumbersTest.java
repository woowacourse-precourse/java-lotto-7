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
    @DisplayName("유효하지 않은 형식의 당첨 번호 입력 시 예외 발생")
    void invalidWinningNumbersFormat() {
        String input = "1,2,3,4,5"; // 번호가 부족한 경우

        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.from(input),
                "유효하지 않은 형식의 당첨 번호 입력 시 예외가 발생해야 합니다.");
    }
}