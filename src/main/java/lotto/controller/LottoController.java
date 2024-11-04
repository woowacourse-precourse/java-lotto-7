package lotto.controller;


import java.util.List;
import lotto.domain.BonusNumber;
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
        List<Integer> winningNumbers = requestWinningLotto();
        BonusNumber bonusNumber = requestBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
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

    private List<Integer> requestWinningLotto() {
        output.printWinningLottoPrompt();
        while (true) {
            try {
                String winningLottoInput = input.getWinningLotto();
                return lottoValidationService.validateWinningLotto(winningLottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber requestBonusNumber(List<Integer> winningNumbers) {
        output.printBonusNumberPrompt();
        while (true) {
            try {
                String bonusNumberInput = input.getBonusNumber();
                int bonusNumber = lottoValidationService.validateBonusNumber(bonusNumberInput, winningNumbers);
                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
