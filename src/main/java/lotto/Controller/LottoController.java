package lotto.Controller;

import java.util.List;
import lotto.Input.InputView;
import lotto.Output.OutputView;
import lotto.Service.LottoService;
import lotto.WinningLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseLottos();
        printLottos(purchaseAmount);
        createWinningNumbers();
    }

    private void printLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = generateLottos(purchaseAmount);
        outputView.printLottos(lottos);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        return lottoService.generateLottos(purchaseAmount.getAmount());
    }

    private PurchaseAmount purchaseLottos() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return PurchaseAmount.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLottoNumbers createWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return WinningLottoNumbers.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
