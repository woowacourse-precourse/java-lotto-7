package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoGenerator lottoGenerator;
    private Validator validator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        validator = new Validator();
        int purchaseAmount = validatePurchaseAmount();

        lottoGenerator = new LottoGenerator(purchaseAmount / 1000);
        List<Lotto> lottos = lottoGenerator.generateLottos();
        outputView.displayLottoCount(lottoGenerator.getLottoCnt());
    }

    public int validatePurchaseAmount() {
        int purchaseAmount = 0;
        while (true) {
            try {
                purchaseAmount = inputView.getPurchaseAmount();
                validator.validatePositiveAmount(purchaseAmount);
                validator.validateAmountUnit(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }
}