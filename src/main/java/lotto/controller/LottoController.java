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
        Lottos lottos = getLottos(purchaseAmount);

        WinningNumbers winningNumbers = tryInputWinningNumbers();

        LottoWinningResult winningResult = getWinningResult(lottos, winningNumbers);
        displayWinningResult(winningResult);

        displayRateOfReturn(winningResult, purchaseAmount);
    }

    private Lottos getLottos(PurchaseAmount purchaseAmount) {
        int quantity = getQuantity(purchaseAmount);
        Lottos lottos = issuLottos(quantity);
        displayIssuedLottoByQuantity(quantity, lottos);
        return lottos;
    }

    private int getQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateQuantity();
    }

    private Lottos issuLottos(int quantity) {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumbersStrategy());
        return lottoGenerator.issues(quantity);
    }

    private void displayIssuedLottoByQuantity(int quantity, Lottos lottos) {
        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);
    }

    private WinningNumbers tryInputWinningNumbers() {
        Lotto winningLottoNumbers = tryInputWinningLottoNumbers();
        return tryInputBonusNumber(winningLottoNumbers);
    }

    private LottoWinningResult getWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        LottoWinningCalculator winningCalculator = new LottoWinningCalculator(new LottoWinningStrategy());
        return winningCalculator.calculateWinningResult(lottos, winningNumbers);
    }

    private void displayRateOfReturn(LottoWinningResult winningResult, PurchaseAmount purchaseAmount) {
        double rateOfReturn = getRateOfReturn(winningResult, purchaseAmount);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void displayWinningResult(LottoWinningResult winningResult) {
        outputView.printLottoWinningResult(winningResult.getLottoWinningResult());
    }

    private double getRateOfReturn(LottoWinningResult winningResult, PurchaseAmount purchaseAmount) {
        return winningResult.calculateRateOfReturn(purchaseAmount);
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
