package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @Test
    void 로또_수익률을_구한다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lotteries.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lotteries.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lotteries.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lotteries.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lotteries.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lotteries.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lotteries.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Map<Rank, Integer> ranking = lottoResultCalculator.calculateRanking(lotteries);
        double rateOfReturn = lottoResultCalculator.calculateRateOfReturn(ranking, 8000);

        assertEquals(62.5, rateOfReturn);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_6개_이면_1등이다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.FIRST_PLACE, rank);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_5개_이고_보너스_번호가_일치하면_2등이다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.SECOND_PLACE, rank);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_5개_이면_3등이다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.THIRD_PLACE, rank);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_4개_이면_4등이다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 42, 43));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.FORTH_PLACE, rank);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_3개_이면_5등이다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 41, 42, 43));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.FIFTH_PLACE, rank);
    }

    @Test
    void 당첨_번호와_일치하는_번호가_3개_미만이면_등수가_없다() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Rank rank = lottoResultCalculator.calculateRanking(userLotto);

        assertEquals(Rank.NONE, rank);
    }

}