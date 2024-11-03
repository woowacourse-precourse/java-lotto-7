package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.money.PurchaseAmount;
import lotto.domain.rank.LottoRank;
import lotto.exception.LottoApplicationException;
import lotto.view.input.InputHandler;
import lotto.view.output.OutputHandler;

public class LottoView {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoView(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public PurchaseAmount getPurchaseAmountFromUser() {
        outputHandler.askPurchaseAmount();
        PurchaseAmount purchaseAmount = inputHandler.getPurchaseAmount();
        outputHandler.showEmptyLine();
        return purchaseAmount;
    }

    public Lotto getWinningNumbersFromUser() {
        outputHandler.askWinningNumbers();
        Lotto winningNumbers = inputHandler.getWinningNumbers();
        outputHandler.showEmptyLine();
        return winningNumbers;
    }

    public LottoNumber getBonusNumberFromUser() {
        outputHandler.askBonusNumber();
        LottoNumber bonusNumber = inputHandler.getBonusNumber();
        outputHandler.showEmptyLine();
        return bonusNumber;
    }

    public void showPurchasedLottos(List<Lotto> purchasedLottos) {
        outputHandler.showPurchasedLottos(purchasedLottos);
    }

    public void showWinningStatistics(Map<LottoRank, Integer> ranks, double rateOfReturn) {
        outputHandler.showWinningStatistics(ranks, rateOfReturn);
    }

    public void showLottoApplicationException(LottoApplicationException exception) {
        outputHandler.showLottoApplicationException(exception);
    }

}
