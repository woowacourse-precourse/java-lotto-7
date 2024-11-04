package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoMarket;
import lotto.domain.NumbersComparator;
import lotto.domain.ProfitRatioCalculator;
import lotto.domain.WinningNumbers;

public class LottoService {

    public List<Lotto> buyLotto(int money) {
        LottoMarket lottoMarket = new LottoMarket();
        return lottoMarket.buyLotto(money);
    }

    public int[] compareNumbers(List<Lotto> myLottos, List<Integer> inputNumbers, int inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, inputBonusNumber);
        NumbersComparator numbersComparator = new NumbersComparator(myLottos, winningNumbers);
        return numbersComparator.determineRank();
    }

    public float calculateProfit(int[] result, List<Lotto> myLottos) {
        ProfitRatioCalculator profitRatioCalculator = new ProfitRatioCalculator(result, myLottos);
        return profitRatioCalculator.calculateProfitRatio();
    }
}
