package lotto;

import lotto.controller.LottoController;
import lotto.service.AmountValidatorService;
import lotto.service.IntegerParserService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        IntegerParserService integerParserService = new IntegerParserService();
        AmountValidatorService amountValidatorService = new AmountValidatorService();
        LottoPurchaseService lottoService = new LottoPurchaseService();
        LottoResultService lottoResultService = new LottoResultService();

        InputView inputView = new InputView(integerParserService, amountValidatorService, lottoService);
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService, lottoResultService);

        lottoController.run();
    }

}
