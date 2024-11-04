package lotto.model;

import lotto.WinnerPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class LottoProcessTest {

    @Test
    void getLottoNumbers() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> lottoNumbers = lottoProcess.getRandomLottoNumbers();
        System.out.println(lottoNumbers);
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);

    }

    @Test
    void 당첨_번호_개수_통계_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(7, 8, 9, 10, 1, 2));
        LottoProcess lottoProcess = new LottoProcess();
        int result = lottoProcess.calculateWinningCount(lottoNumbers, winningNumbers);
        System.out.println("winningStatistics = " + lottoProcess.getWinningStatistics());
        System.out.println(lottoProcess.getWinningStatistics());


        Assertions.assertThat(result).isEqualTo(2);
    }


    @Test
    void 보너스_번호가_당첨번호들에_포함여부() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean result = lottoProcess.validateBonusNumberInWinningNumbersInLottoProcess(6, winningNumbers);
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    void addWinningStatisticsTest() {
        LottoProcess lottoProcess = new LottoProcess();
        lottoProcess.addWinningStatisticValue(0);
        lottoProcess.addWinningStatisticValue(3);
        lottoProcess.addWinningStatisticValue(4);

        System.out.println("lottoProcess.getWinningStatistics() = " + lottoProcess.getWinningStatistics());

    }


    @Test
    void getWinnerStatisticsIndexByCountMatchTest() {
        int winnerStatisticsIndexTrue = WinnerPrice.getWinnerStatisticsIndexByCountMatch(2, true);
        int winnerStatisticsIndexFalse = WinnerPrice.getWinnerStatisticsIndexByCountMatch(-10, false);
        System.out.println("winnerStatisticsIndexTrue = " + winnerStatisticsIndexTrue);
        System.out.println("winnerStatisticsIndexFalse = " + winnerStatisticsIndexFalse);

    }

    @Test
    void 당첨개수를_통해_당첨통계_저장하는_배열의_인덱스_반환() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        lottoProcess.reflectWinningCountToStatistics(lottoNumbers, winningNumbers, 6);
        System.out.println("winningNumbers = " + lottoProcess.getWinningStatistics());
        Assertions.assertThat(lottoProcess.getWinningStatistics().get(3)).isEqualTo(1);

    }

    @Test
    void 수익금_계산() {
        LottoProcess lottoProcess = new LottoProcess();
        lottoProcess.addWinningStatisticValue(0);
        lottoProcess.addWinningStatisticValue(1);
        lottoProcess.addWinningStatisticValue(3);
        long profit = lottoProcess.calculateProfit();
        System.out.println("profit = " + profit);
        Assertions.assertThat(profit).isEqualTo(30055000l);

    }

    @Test
    void 총_수익률_계산() {
        LottoProcess lottoProcess = new LottoProcess();
        lottoProcess.addWinningStatisticValue(0);
        System.out.println("lottoProcess.getWinningStatistics() = " + lottoProcess.getWinningStatistics());
        double profitRate = lottoProcess.calculateProfitRate(8000);
        System.out.println("profitRate = " + profitRate);
        Assertions.assertThat(profitRate).isEqualTo(62.5);
    }
}
