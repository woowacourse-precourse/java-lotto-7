package lotto.controller;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoValidationService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoValidationService lottoValidationService;

    public LottoController(Input input, Output output, LottoValidationService lottoValidationService) {
        this.input = input;
        this.output = output;
        this.lottoValidationService = lottoValidationService;
    }

    public void run() {
        PurchaseAmount purcharseAmount = requestPurchaseAmount();
        int count = purcharseAmount.calculateLottoCount();
        Lottos lottos = purchaseLotto(count);
        WinningLotto winningLotto = requestWinningLotto();

    }

    private PurchaseAmount requestPurchaseAmount() {
        output.printPurchaseAmountPrompt();
        while (true) {
            try {
                String amountInput = input.getPurchaseAmount();
                int amount = lottoValidationService.validatePurchaseAmount(amountInput);
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos purchaseLotto(int count) {
        Lottos lottos = Lottos.generateLottos(count);
        output.printLottos(lottos);
        return lottos;
    }

    private WinningLotto requestWinningLotto() {
        output.printWinningLottoPrompt();
        while (true) {
            try {
                String winningLottoInput = input.getWinningLotto();
                List<Integer> winningLotto = lottoValidationService.validateWinningLotto(winningLottoInput);
                Lotto lotto = new Lotto(winningLotto);
                return new WinningLotto(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
