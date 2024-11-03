package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.view.input.InputHandler;
import lotto.view.output.OutputHandler;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new LottoNumberGenerator());
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        LottoView lottoView = new LottoView(inputHandler, outputHandler);

        LottoController lottoController = new LottoController(lottoService, lottoView);

        lottoController.run();
    }

}
