package lotto.config;

import lotto.controller.LottoController;
import lotto.model.AutoLottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.YieldCalculator;
import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final InputValidator inputValidator = new InputValidator();
    private static final LottoNumberParser lottoNumberParser = new LottoNumberParser(inputValidator);
    private static final AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(inputValidator);
    private static final LottoMatcher lottoMatcher = new LottoMatcher();
    private static final YieldCalculator yieldCalculator = new YieldCalculator();
    private static final LottoService lottoService =
            new LottoService(lottoNumberParser, autoLottoGenerator, lottoMatcher, yieldCalculator);

    private LottoConfig() {
    }

    public static LottoController lottoController() {
        return new LottoController(
                inputView,
                outputView,
                inputValidator,
                lottoService
        );
    }
}
