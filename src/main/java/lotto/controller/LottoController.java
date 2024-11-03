package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoWinningCalculator;
import lotto.model.LottoWinningResult;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.model.lottonumberstrategy.LottoNumbersStrategy;
import lotto.model.lottowinningstrategy.LottoWinningStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = tryInputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseAmount);

        WinningNumbers winningNumbers = issueWinningNumbers();

        LottoWinningResult winningResult = getWinningResult(lottos, winningNumbers);
        getRateOfReturn(winningResult, purchaseAmount);
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        int quantity = purchaseAmount.calculateQuantity();
        Lottos lottos = issueLottoByQuantity(quantity);

        displayIssuedLottoByQuantity(quantity, lottos);
        return lottos;
    }

    private Lottos issueLottoByQuantity(int quantity) {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumbersStrategy());
        return lottoGenerator.issues(quantity);
    }

    private void displayIssuedLottoByQuantity(int quantity, Lottos lottos) {
        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winningLottoNumbers = tryInputWinningLottoNumbers();
        return tryInputBonusNumber(winningLottoNumbers);
    }

    private LottoWinningResult getWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        LottoWinningResult winningResult = calculateWinningByLotto(lottos, winningNumbers);

        displayWinningResult(winningResult);
        return winningResult;
    }

    private void displayWinningResult(LottoWinningResult winningResult) {
        outputView.printLottoWinningResult(winningResult.getLottoWinningResult());
    }

    private void getRateOfReturn(LottoWinningResult winningResult, PurchaseAmount purchaseAmount) {
        double rateOfReturn = winningResult.calculateRateOfReturn(purchaseAmount);
        displayRateOfReturn(rateOfReturn);
    }

    private void displayRateOfReturn(double rateOfReturn) {
        outputView.printRateOfReturn(rateOfReturn);
    }

    private LottoWinningResult calculateWinningByLotto(Lottos lottos, WinningNumbers winningNumbers) {
        LottoWinningCalculator winningCalculator = new LottoWinningCalculator(new LottoWinningStrategy());
        return winningCalculator.calculateWinningResult(lottos, winningNumbers);
    }

    private PurchaseAmount tryInputPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                int purchaseAmount = inputView.inputPurchaseAmount();
                return PurchaseAmount.from(purchaseAmount);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Lotto tryInputWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbersMessage();
                List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
                return Lotto.from(winningLottoNumbers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WinningNumbers tryInputBonusNumber(Lotto winningLottoNumbers) {
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                int bonusNumber = inputView.inputBonusNumber();
                return WinningNumbers.of(winningLottoNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
