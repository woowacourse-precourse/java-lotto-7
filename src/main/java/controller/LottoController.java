package controller;

import java.util.List;
import lotto.domain.LottoPrizeResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinningNumbers;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputWinningNumbersView;

import static lotto.view.OutputBuyLottoCountView.printBuyLotto;
import static lotto.view.OutputLottosView.printLottos;
import static lotto.view.OutputLottoResultView.printResult;

public class LottoController {
    public void start() {
        Money money = getBuyLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottos(lottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        LottoPrizeResult lottoPrizeResult = new LottoPrizeResult();
        calculateLottoPrizeResult(lottoPrizeResult, winningNumbers, lottos);

        ProfitRate profitRate = getProfitRate(money, lottoPrizeResult);
        printResult(lottoPrizeResult, profitRate);

    }

    private Money getBuyLottoMoney() {
        Integer moneyValue = new InputBuyLottoView().getMoneyValue();
        return new Money(moneyValue);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(money.getBuyLottoCount()));
    }

    private WinningNumbers getWinningNumbers() {
        InputWinningNumbersView inputWinningLottoView = new InputWinningNumbersView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumberList = inputWinningLottoView.getWinningNumberList();
        Integer bonusNumber = inputBonusNumberView.getBonusNumber();

        return new WinningNumbers(winningNumberList, bonusNumber);
    }

    private void calculateLottoPrizeResult(LottoPrizeResult lottoPrizeResult, WinningNumbers winningNumbers, Lottos lottos) {
        lottoPrizeResult.calculatePrizeResult(winningNumbers, lottos);
    }

    private ProfitRate getProfitRate(Money money, LottoPrizeResult lottoPrizeResult) {
        return new ProfitRate(money, lottoPrizeResult);
    }
}
