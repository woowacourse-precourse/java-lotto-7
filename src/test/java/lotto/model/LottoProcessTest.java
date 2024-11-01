package lotto.model;

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
        boolean result = lottoProcess.validateBonusNumInWinningNumbers(6, winningNumbers);
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
}