package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.LottoResultController;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.util.LottoNumberGenerator;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private static final AppConfig instance = new AppConfig();

    private InputView inputView;
    private OutputView outputView;
    private LottoNumberGenerator lottoNumberGenerator;
    private Validator validator;
    private Parser parser;
    private LottoService lottoService;
    private LottoResultService lottoResultService;
    private LottoController lottoController;
    private LottoResultController lottoResultController;

    private AppConfig() { }

    public static AppConfig getAppConfig() {
        return instance;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoService(), inputView(), outputView());
        }
        return lottoController;
    }

    public LottoResultController lottoResultController() {
        if (lottoResultController == null) {
            lottoResultController = new LottoResultController(lottoResultService(), outputView());
        }
        return lottoResultController;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            lottoService = new LottoService(lottoNumberGenerator(), parser());
        }
        return lottoService;
    }

    public LottoResultService lottoResultService() {
        if (lottoResultService == null) {
            lottoResultService = new LottoResultService();
        }
        return lottoResultService;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public LottoNumberGenerator lottoNumberGenerator() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = new LottoNumberGenerator();
        }
        return lottoNumberGenerator;
    }

    public Validator validator() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;
    }

    public Parser parser() {
        if (parser == null) {
            parser = new Parser(validator());
        }
        return parser;
    }
}
