package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoMarket;
import lotto.domain.NumbersComparator;
import lotto.domain.ProfitRatioCalculator;
import lotto.domain.SixNumbers;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoService {

    public List<Lotto> buyLotto(int money) {
        LottoMarket lottoMarket = new LottoMarket();
        return lottoMarket.buyLotto(money);
    }

    public WinningNumbers getWinningNumbers() {
        List<Integer> inputNumbers = InputView.readWinningNumbers();
        SixNumbers sixNumbers = new SixNumbers(inputNumbers);
        int inputBonusNumber = InputView.readBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        return new WinningNumbers(sixNumbers, bonusNumber);
    }

    public int[] compareNumbers(List<Lotto> myLottos, WinningNumbers winningNumbers) {
        NumbersComparator numbersComparator = new NumbersComparator(myLottos, winningNumbers);
        return numbersComparator.determineRank();
    }

    public float calculateProfit(int[] result, List<Lotto> myLottos) {
        ProfitRatioCalculator profitRatioCalculator = new ProfitRatioCalculator(result, myLottos);
        return profitRatioCalculator.calculateProfitRatio();
    }
}
