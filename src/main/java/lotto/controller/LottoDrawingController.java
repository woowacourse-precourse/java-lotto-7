package lotto.controller;

import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoPurchase;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Profit;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import lotto.view.BonusNumberInputView;
import lotto.view.ErrorOutputView;
import lotto.view.LottoResultOutputView;
import lotto.view.ProfitOutputView;
import lotto.view.WinningNumbersInputView;

public class LottoDrawingController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;
    private final WinningNumbersInputView winningNumbersInputView;
    private final BonusNumberInputView bonusNumberInputView;

    public LottoDrawingController(Lottos lottos,
                                  LottoPurchase lottoPurchase,
                                  WinningNumbersInputView winningNumbersInputView,
                                  BonusNumberInputView bonusNumberInputView) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
        this.winningNumbersInputView = winningNumbersInputView;
        this.bonusNumberInputView = bonusNumberInputView;
    }

    public void start() {
        WinningNumbers winningNumbers = drawWinningNumbers();

        BonusNumber bonusNumber = drawBonusNumber(winningNumbers);

        LottoResult lottoResult = getLottoResult(winningNumbers, bonusNumber);
        printLottoResult(lottoResult.getLottoResult());

        Profit profit = getProfit(lottoResult);
        printProfit(profit.getProfitRate());
    }

    private WinningNumbers drawWinningNumbers() {
        winningNumbersInputView.printWinningNumbersInputGuide();

        return getWinningNumbers();
    }

    private WinningNumbers getWinningNumbers() {
        WinningNumbers winningNumbers;

        try {
            winningNumbers = new WinningNumbers(winningNumbersInputView.getWinningNumbers());

        } catch (IllegalArgumentException e) {

            ErrorOutputView.printErrorMessage(e);

            return getWinningNumbers();
        }

        return winningNumbers;
    }

    private BonusNumber drawBonusNumber(WinningNumbers winningNumbers) {
        bonusNumberInputView.printBonusNumberInputGuide();

        return getBonusNumber(winningNumbers);
    }


    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber;

        try {
            bonusNumber = new BonusNumber(
                    bonusNumberInputView.getBonusNumber(),
                    winningNumbers.getWinningNumbers()
            );

        } catch (IllegalArgumentException e) {

            ErrorOutputView.printErrorMessage(e);

            return getBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }

    private LottoResult getLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    private void printLottoResult(Map<Rank, Integer> lottoResult) {
        LottoResultOutputView lottoResultOutputView = new LottoResultOutputView();
        lottoResultOutputView.printLottoResultOutputGuide();

        lottoResultOutputView.printLottoResult(lottoResult);
    }

    private Profit getProfit(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.getLottoResult();
        long purchaseAmount = lottoPurchase.getPurchaseAmount();

        return new Profit(result, purchaseAmount);
    }

    private void printProfit(double profitRate) {
        ProfitOutputView profitOutputView = new ProfitOutputView();
        profitOutputView.printProfitRate(profitRate);
    }
}
