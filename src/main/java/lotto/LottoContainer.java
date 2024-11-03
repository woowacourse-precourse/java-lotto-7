package lotto;

import lotto.controller.InputTemplate;
import lotto.controller.InputValidator;
import lotto.controller.IteratorInputHandler;
import lotto.controller.LottoController;
import lotto.domain.strategy.RandomNumberGenerationStrategy;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoContainer {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private InputTemplate inputTemplate;
    private LottoService lottoService;
    private IteratorInputHandler iteratorInputHandler;
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

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            return new IteratorInputHandler(inputView(), inputValidator(), inputTemplate());
        }
        return iteratorInputHandler;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            return new LottoService(new RandomNumberGenerationStrategy());
        }
        return lottoService;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            return new LottoController(iteratorInputHandler(), outputView(), lottoService());
        }
        return lottoController;
    }
}
