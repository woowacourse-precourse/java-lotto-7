package lotto.config;

import lotto.view.InputHandler;
import lotto.util.InputValidator;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultChecker;
import lotto.service.LottoService;
import lotto.view.OutputHandler;
import lotto.app.Application;

public class AppConfig {
    public static Application createApplication() {
        InputValidator inputValidator = new InputValidator();
        InputHandler inputHandler = new InputHandler(inputValidator);
        OutputHandler outputHandler = new OutputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        LottoService lottoService = new LottoService(lottoGenerator, lottoResultChecker);

        return new Application(inputHandler, outputHandler, lottoService);
    }
}
