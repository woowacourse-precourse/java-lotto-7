package lotto;

import lotto.controller.InputHandler;
import lotto.controller.InputTemplate;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoContainer {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private InputTemplate inputTemplate;
    private LottoService lottoService;
    private InputHandler inputHandler;
    private LottoController lottoController;

    public InputView inputView() {
        if (inputView == null) {
            return new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            return new OutputView();
        }
        return outputView;
    }

    public InputValidator inputValidator() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public InputTemplate inputTemplate() {
        if (inputTemplate == null) {
            return new InputTemplate(outputView());
        }
        return inputTemplate;
    }

    public InputHandler inputHandler() {
        if (inputHandler == null) {
            return new InputHandler(inputView(), inputValidator(), inputTemplate());
        }
        return inputHandler;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            return new LottoService();
        }
        return lottoService;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            return new LottoController(outputView(), lottoService(), inputHandler());
        }
        return lottoController;
    }
}
