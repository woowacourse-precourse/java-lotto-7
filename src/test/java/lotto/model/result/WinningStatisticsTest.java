package lotto.model.result;

import lotto.model.draw.Bonus;
import lotto.model.draw.LottoDraw;
import lotto.model.draw.LottoNumbersGenerator;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTickets;
import lotto.model.result.WinningRank;
import lotto.model.result.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningStatisticsTest {

    private LottoDraw lottoDraw;
    private LottoTickets lottoTickets;

    @BeforeEach
    @DisplayName("당첨 번호와 보너스 번호를 설정하고 로또 티켓을 생성합니다.")
    public void setUp() {

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(winningNumbers);
        Bonus bonus = new Bonus(bonusNumber);
        lottoDraw = LottoDraw.by(lotto, bonus);


        List<LottoNumbersGenerator> lottoNumbersList = Arrays.asList(
                LottoNumbersGenerator.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
                LottoNumbersGenerator.of(Arrays.asList(3, 5, 11, 16, 32, 38)),
                LottoNumbersGenerator.of(Arrays.asList(7, 11, 16, 35, 36, 44)),
                LottoNumbersGenerator.of(Arrays.asList(1, 8, 11, 31, 41, 42)),
                LottoNumbersGenerator.of(Arrays.asList(13, 14, 16, 38, 42, 45)),
                LottoNumbersGenerator.of(Arrays.asList(7, 11, 30, 40, 42, 43)),
                LottoNumbersGenerator.of(Arrays.asList(2, 13, 22, 32, 38, 45)),
                LottoNumbersGenerator.of(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
        lottoTickets = LottoTickets.createTickets(lottoNumbersList);
    }

    @Test
    @DisplayName("WinningStatistics를 통해 당첨 통계 및 수익률을 올바르게 계산되는지 확인합니다.")
    public void testWinningStatistics() {
        WinningStatistics winningStatistics = WinningStatistics.from(lottoDraw, lottoTickets);

        assertEquals(1, winningStatistics.getWinningStatistics(WinningRank.FIFTH));  // 3개 일치
        assertEquals(0, winningStatistics.getWinningStatistics(WinningRank.FOURTH)); // 4개 일치
        assertEquals(0, winningStatistics.getWinningStatistics(WinningRank.THIRD));  // 5개 일치
        assertEquals(0, winningStatistics.getWinningStatistics(WinningRank.SECOND)); // 5개 일치 + 보너스
        assertEquals(0, winningStatistics.getWinningStatistics(WinningRank.FIRST));  // 6개 일치


        assertEquals("62.5", winningStatistics.getRewardRate());
    }
}