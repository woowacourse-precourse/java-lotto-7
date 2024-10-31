package lotto.domain;

import java.util.List;
import lotto.domain.winning.WinningStatus;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private WinningStatus winningStatus;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningStatus = new WinningStatus();
        winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);
    }

    @Test
    @DisplayName("당첨 횟수 증가 테스트")
    void addWinningTest() {
        winningStatus.addWinning("3개");
        assertEquals(1, winningStatus.getPrizeCount("3개"));
    }

    @Test
    @DisplayName("총 상금 계산 테스트")
    void calculateTotalPrizeTest() {
        winningStatus.addWinning("3개");
        winningStatus.addWinning("4개");
        winningStatus.addWinning("5개");
        int expectedTotalPrize = (1 * 5000) + (1 * 50000) + (1 * 1500000);
        assertEquals(expectedTotalPrize, winningStatus.calculateTotalPrize());
    }

    @Test
    @DisplayName("당첨 번호 추출 테스트")
    void getWinningNumbersTest() {
        List<Integer> expectedWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expectedWinningNumbers, winningNumbers.getNumbers());
    }

    @Test
    @DisplayName("보너스 번호 확인 테스트")
    void getBonusNumberTest() {
        assertEquals(7, winningNumbers.getBonus());
    }

    @Test
    @DisplayName("초기 당첨 횟수 0 확인 테스트")
    void initialPrizeCountTest() {
        assertEquals(0, winningStatus.getPrizeCount("3개"));
        assertEquals(0, winningStatus.getPrizeCount("4개"));
        assertEquals(0, winningStatus.getPrizeCount("5개"));
        assertEquals(0, winningStatus.getPrizeCount("5개 + 보너스"));
        assertEquals(0, winningStatus.getPrizeCount("6개"));
    }

    @Test
    @DisplayName("당첨 상금 금액 확인 테스트")
    void prizeAmountTest() {
        assertEquals(5000, winningStatus.getPrizeAmount("3개"));
        assertEquals(50000, winningStatus.getPrizeAmount("4개"));
        assertEquals(1500000, winningStatus.getPrizeAmount("5개"));
        assertEquals(30000000, winningStatus.getPrizeAmount("5개 + 보너스"));
        assertEquals(2000000000, winningStatus.getPrizeAmount("6개"));
    }
}