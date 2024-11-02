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
        PurchaseAmount purchaseAmount = tryPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumbersStrategy());
        int quantity = purchaseAmount.calculateQuantity();
        Lottos lottos = lottoGenerator.issues(quantity);

        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = issueWinningNumbers();

        LottoWinningResult winningResult = getLottoWinningResult(lottos, winningNumbers);
        outputView.printLottoWinningResult(winningResult.getLottoWinningResult());

        double rateOfReturn = winningResult.calculateRateOfReturn(purchaseAmount);
        outputView.printRateOrReturn(rateOfReturn);
    }

    private LottoWinningResult getLottoWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        LottoWinningCalculator winningCalculator = new LottoWinningCalculator(new LottoWinningStrategy());
        return winningCalculator.calculateWinningResult(lottos, winningNumbers);
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winningLottoNumbers = tryWinningLottoNumbers();
        return tryBonusNumber(winningLottoNumbers);
    }

    private PurchaseAmount tryPurchaseAmount() {
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

    private Lotto tryWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbersMessage();
                List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
                return Lotto.of(winningLottoNumbers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WinningNumbers tryBonusNumber(Lotto winningLottoNumbers) {
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
