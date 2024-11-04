package lotto.model;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.dto.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @DisplayName("로또 계산기는 1등부터 5등 그리고 미 당첨된 로또의 갯수를 반환해야 한다.")
    @Test
    void getLottoResult() {
        //given
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = 7;
        LottoCalculator lottoCalculator = new LottoCalculator(winningLotto, bonusNumber);
        LottoTicket fifthRankLottoTicket = getLottoTicket();

        //when
        WinningStatistics winningStatistics = lottoCalculator.getWinningStatistics(fifthRankLottoTicket);
        HashMap<Rank, Integer> lottoResult = winningStatistics.getLottoResult();

        //then
        assertThat(lottoResult).containsKeys(LOSE, FIFTH, FOURTH, THIRD, SECOND, FIRST);
        assertThat(lottoResult.get(FIFTH)).isEqualTo(1);
    }

    @DisplayName("로또 계산기는 로또 티켓에 대한 수익률을 반환해야 한다.")
    @Test
    void getEarningRate() {
        //given
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = 7;
        LottoCalculator lottoCalculator = new LottoCalculator(winningLotto, bonusNumber);
        LottoTicket lottoTicket = getLottoTicket();

        //when
        WinningStatistics winningStatistics = lottoCalculator.getWinningStatistics(lottoTicket);
        double earningRate = winningStatistics.getEarningRate();

        //then
        assertThat(earningRate).isEqualTo(500.0);
    }

    private static Lotto getWinningLotto() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        return new Lotto(winningNumbers);
    }

    private static LottoTicket getLottoTicket() {
        List<Integer> numbers = List.of(4, 5, 6, 7, 8, 9);
        int purchaseAmount = 1000;
        Lotto myLotto = new Lotto(numbers);
        return new LottoTicket(List.of(myLotto), purchaseAmount);
    }

}