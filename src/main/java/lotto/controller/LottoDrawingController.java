package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoPurchase;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Profit;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import lotto.view.LottoResultOutputView;
import lotto.view.ProfitOutputView;
import lotto.view.WinningNumbersInputView;

public class LottoDrawingController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;

    public LottoDrawingController(Lottos lottos, LottoPurchase lottoPurchase) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
    }

    public void start() {
        WinningNumbers winningNumbers = setWinningNumbers();
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);

        Map<Rank, Integer> result = lottoResult.getLottoResult();
        long purchaseAmount = lottoPurchase.getPurchaseAmount();

        printLottoResult(result);

        Profit profit = new Profit(result, purchaseAmount);

        printProfit(profit.getProfitRate());
    }

    private WinningNumbers setWinningNumbers() {
        WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();
        winningNumbersInputView.printWinningNumbersInputGuide();
        List<Integer> winningNumbers = winningNumbersInputView.getWinningNumbers();

        winningNumbersInputView.printBonusNumberInputGuide();
        int bonusNumber = winningNumbersInputView.getBonusNumber();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void printLottoResult(Map<Rank, Integer> lottoResult) {
        LottoResultOutputView lottoResultOutputView = new LottoResultOutputView();
        lottoResultOutputView.printLottoResultOutputGuide();

        lottoResultOutputView.printLottoResult(lottoResult);
    }

    private void printProfit(double profitRate) {
        ProfitOutputView profitOutputView = new ProfitOutputView();
        profitOutputView.printProfitRate(profitRate);
    }
}
