package lotto;

import lotto.controller.LottoController;
import lotto.parser.InputParser;
import lotto.parser.InputParserImpl;
import lotto.service.IncomeService;
import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        InputParser inputParser = new InputParserImpl();

        ValidateService validateService = new ValidateService();
        LottoService lottoService = new LottoService();
        IncomeService incomeService = new IncomeService();

        LottoController lottoController = new LottoController(inputHandler, outputHandler, inputParser,
                                                            validateService, lottoService, incomeService);

        lottoController.run();
    }
}
