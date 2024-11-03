package controller;

import lotto.LottoGenerator;
import lotto.Lottos;
import lotto.PurchaseAmount;
import lotto.statistics.RevenueCalculator;
import lotto.winning.BonusNumber;
import lotto.winning.WinningLotto;
import lotto.winning.WinningNumbers;
import view.InputView;
import view.ResultView;

public class LottoController {

    private final InputView input;
    private final ResultView output;

    public LottoController(InputView input, ResultView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        PurchaseAmount purchaseAmount = enterPurchaseAmount();

        int purchaseCount = computePurchaseCount(purchaseAmount);
        output.showLottoPurchaseCount(purchaseCount);

        Lottos lottos = issueLottos(purchaseCount);
        output.showCreatedLottos(lottos);

        WinningLotto winningLotto = issueWinningLotto();

        matchLottoAndWinningLotto(lottos, winningLotto);

        output.showWinningStatistics(computeRevenue(purchaseAmount));
    }

    private PurchaseAmount enterPurchaseAmount() {
        return input.inputPurchaseAmount();
    }

    private int computePurchaseCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculatePurchaseCount();
    }

    private Lottos issueLottos(int purchaseCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.createLottos(purchaseCount);
    }

    private WinningLotto issueWinningLotto() {
        WinningNumbers winningNumbers = input.inputWinningNumbers();
        BonusNumber bonusNumber = input.inputBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void matchLottoAndWinningLotto(Lottos lottos, WinningLotto winningLotto) {
        lottos.compare(winningLotto);
    }

    private double computeRevenue(PurchaseAmount purchaseAmount) {
        return RevenueCalculator.calculateRevenue(purchaseAmount);
    }
}
