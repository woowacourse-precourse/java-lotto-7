package lotto;

import lotto.controller.LottoController;
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
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        LottoService lottoService = new LottoService(lottoTicketGenerator);

        LottoController lottoController = new LottoController(inputHandler, outputHandler, lottoService);

        lottoController.run();
    }
}
