package lotto;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        LottoController lottoController = new LottoController(inputView, outputView, lottoService,
                purchaseAmountValidator, bonusNumberValidator);

        lottoController.run();
    }
}
