package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.PurchaseAmount;
import lotto.model.lottonumberstrategy.LottoNumbersStrategy;
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
        int quantity = purchaseAmount.calculateQuantity();

        LottoGenerator lottoGenerator = LottoGenerator.from(new LottoNumbersStrategy());
        List<Lotto> lottos = lottoGenerator.issues(quantity);

        outputView.printQuantity(quantity);
        outputView.printLottos(lottos);

        Lotto winningLottoNumbers = tryWinningLottoNumbers();
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
                List<Integer> numbers = inputView.inputWinningLottoNumbers();
                return Lotto.of(numbers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
