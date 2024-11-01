package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.constant.LottoResultsTracker;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.CalculatorService;
import lotto.service.WinningNumbersService;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService(new WinningNumbersService());
    WinningNumbersService winningNumbersService = new WinningNumbersService();
    LottoResultsTracker lottoResultsTracker = new LottoResultsTracker();


    @Test
    void 수익률_계산() {
        double profit = 5000;
        double lottoPrice = 8000;
        String expect = "62.5%";
        String actual = calculatorService.profitCalculate(lottoPrice, profit);

        assertEquals(expect, actual);
    }

    @Test
    void 당첨복권_갯수_추가() {
        String input = "1,2,3,4,7,8";
        int bonus = 9;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        int expect = 1;

        WinningNumbers winningNumbers = winningNumbersService.createWinningNumbers(input);

        LottoRank lottoRank = winningNumbersService.getLottoRank(lotto, winningNumbers, bonus);

        lottoResultsTracker.incrementRankCount(lottoRank);
        int actual = lottoResultsTracker.getRankCount(lottoRank);

        assertEquals(expect, actual);
    }

    @Test
    void 수익_계산() {
        String input = "1,2,3,4,7,8";
        int bonus = 9;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        double expect = 50000;

        WinningNumbers winningNumbers = winningNumbersService.createWinningNumbers(input);
        LottoRank lottoRank = winningNumbersService.getLottoRank(lotto, winningNumbers, bonus);
        lottoResultsTracker.incrementRankCount(lottoRank);

        double actual = calculatorService.getProfit(lottoResultsTracker);

        assertEquals(expect, actual);
    }
}
