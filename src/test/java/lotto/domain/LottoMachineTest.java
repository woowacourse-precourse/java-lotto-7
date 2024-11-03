package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.winning.LottoStatus;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        winningStatus.addWinning(LottoStatus.THREE_MATCH);
        assertEquals(1, winningStatus.getPrizeCount(LottoStatus.THREE_MATCH));
    }

    @Test
    @DisplayName("총 상금 계산 테스트")
    void calculateTotalPrizeTest() {
        winningStatus.addWinning(LottoStatus.THREE_MATCH);
        winningStatus.addWinning(LottoStatus.FOUR_MATCH);
        winningStatus.addWinning(LottoStatus.FIVE_MATCH);

        int expectedTotalPrize = LottoStatus.THREE_MATCH.getPrize()
            + LottoStatus.FOUR_MATCH.getPrize()
            + LottoStatus.FIVE_MATCH.getPrize();

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
        assertEquals(0, winningStatus.getPrizeCount(LottoStatus.THREE_MATCH));
        assertEquals(0, winningStatus.getPrizeCount(LottoStatus.FOUR_MATCH));
        assertEquals(0, winningStatus.getPrizeCount(LottoStatus.FIVE_MATCH));
        assertEquals(0, winningStatus.getPrizeCount(LottoStatus.FIVE_MATCH_WITH_BONUS));
        assertEquals(0, winningStatus.getPrizeCount(LottoStatus.SIX_MATCH));
    }

    @Test
    @DisplayName("당첨 상금 금액 확인 테스트")
    void prizeAmountTest() {
        assertEquals(5_000, LottoStatus.THREE_MATCH.getPrize());
        assertEquals(50_000, LottoStatus.FOUR_MATCH.getPrize());
        assertEquals(1_500_000, LottoStatus.FIVE_MATCH.getPrize());
        assertEquals(30_000_000, LottoStatus.FIVE_MATCH_WITH_BONUS.getPrize());
        assertEquals(2_000_000_000, LottoStatus.SIX_MATCH.getPrize());
    }

    @Test
    @DisplayName("LottoStatus.of() 메서드 테스트")
    void lottoStatusOfTest() {
        assertEquals(LottoStatus.THREE_MATCH, LottoStatus.of(3, false));
        assertEquals(LottoStatus.FOUR_MATCH, LottoStatus.of(4, false));
        assertEquals(LottoStatus.FIVE_MATCH, LottoStatus.of(5, false));
        assertEquals(LottoStatus.FIVE_MATCH_WITH_BONUS, LottoStatus.of(5, true));
        assertEquals(LottoStatus.SIX_MATCH, LottoStatus.of(6, false));
        assertEquals(LottoStatus.NONE, LottoStatus.of(2, false));
    }

    @Test
    @DisplayName("LottoStatus description 테스트")
    void lottoStatusDescriptionTest() {
        assertEquals("3개 일치", LottoStatus.THREE_MATCH.getDescription());
        assertEquals("4개 일치", LottoStatus.FOUR_MATCH.getDescription());
        assertEquals("5개 일치", LottoStatus.FIVE_MATCH.getDescription());
        assertEquals("5개 일치, 보너스 볼 일치", LottoStatus.FIVE_MATCH_WITH_BONUS.getDescription());
        assertEquals("6개 일치", LottoStatus.SIX_MATCH.getDescription());
    }
}