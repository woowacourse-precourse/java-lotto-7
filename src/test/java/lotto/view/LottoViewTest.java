package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoProcess;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoViewTest {


    @Test
    void 로또_번호_출력() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> randomLottoNumbers = lottoProcess.getRandomLottoNumbers();
        Lotto lotto = new Lotto(randomLottoNumbers);
        LottoView lottoView = new LottoView();
        lottoView.outputLottoNumbers(lotto);

    }

    @Test
    void 당첨_통계_테스트() {
        List<Integer> winningStatistics = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        LottoView lottoView = new LottoView();
        lottoView.outputWinnerStatistics(winningStatistics);

    }

    @Test
    void 총수익률_출력() {
        LottoView lottoView = new LottoView();
        LottoProcess lottoProcess = new LottoProcess();
        lottoProcess.addWinningStatisticValue(0);
        System.out.println("lottoProcess.getWinningStatistics() = " + lottoProcess.getWinningStatistics());
        double profitRate = lottoProcess.calculateProfitRate(12000);
        System.out.println("profitRate = " + profitRate);

        lottoView.outputProfitRate(profitRate);

    }

}