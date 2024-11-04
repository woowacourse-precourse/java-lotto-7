package lotto;

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
