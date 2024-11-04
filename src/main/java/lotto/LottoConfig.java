package lotto;

import lotto.controller.InputValidator;
import lotto.controller.IteratorInputHandler;
import lotto.controller.IteratorInputTemplate;
import lotto.controller.LottoController;
import lotto.converter.Converter;
import lotto.converter.StringToIntConverter;
import lotto.domain.strategy.RandomNumberGenerationStrategy;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private IteratorInputTemplate iteratorInputTemplate;
    private LottoService lottoService;
    private IteratorInputHandler iteratorInputHandler;
    private LottoController lottoController;
    private Converter<String, Integer> converter;

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

    public IteratorInputTemplate IteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            return new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            return new IteratorInputHandler(inputView(), inputValidator(), IteratorInputTemplate(), converter());
        }
        return iteratorInputHandler;
    }

    public Converter<String, Integer> converter() {
        if (converter == null) {
            return new StringToIntConverter();
        }
        return converter;
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
