package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.ProfitCalculator;
import lotto.domain.ResultAnalyzer;
import lotto.domain.TicketGenerator;
import lotto.service.LottoService;
import lotto.validator.BasicNumberValidator;
import lotto.validator.NumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ObjectFactory {

    public static LottoController createLottoController() {
        NumberValidator purchaseAmountValidator = new PurchaseAmountValidator();
        NumberValidator basicNumberValidator = new BasicNumberValidator();

        InputView inputView = new InputView(purchaseAmountValidator, basicNumberValidator);
        OutputView outputView = new OutputView();

        TicketGenerator ticketGenerator = new TicketGenerator();
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        LottoService lottoService = new LottoService(ticketGenerator, resultAnalyzer, profitCalculator);

        return new LottoController(inputView, outputView, lottoService);
    }
}
