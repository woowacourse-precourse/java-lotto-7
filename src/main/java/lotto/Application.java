package lotto;

import lotto.controller.LottoController;
import lotto.evaluator.LottoEvaluator;
import lotto.io.ConsoleLottoInputHandler;
import lotto.io.ConsoleLottoOutputHandler;
import lotto.io.LottoInputHandler;
import lotto.io.LottoOutputHandler;
import lotto.service.LottoService;
import lotto.service.LottoTicketGenerator;

public class Application {
    public static void main(String[] args) {
        LottoInputHandler inputHandler = new ConsoleLottoInputHandler();
        LottoOutputHandler outputHandler = new ConsoleLottoOutputHandler();
        LottoEvaluator lottoEvaluator = new LottoEvaluator();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        LottoService lottoService = new LottoService(lottoTicketGenerator, lottoEvaluator);

        LottoController lottoController = new LottoController(inputHandler, outputHandler, lottoService);

        lottoController.run();
    }
}
