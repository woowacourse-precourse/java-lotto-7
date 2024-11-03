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
}