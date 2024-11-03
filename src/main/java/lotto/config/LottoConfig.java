package lotto.config;

import lotto.controller.LottoController;
import lotto.model.AutoLottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.YieldCalculator;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final LottoNumberParser lottoNumberParser = new LottoNumberParser();
    private static final AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    private static final LottoMatcher lottoMatcher = new LottoMatcher();
    private static final YieldCalculator yieldCalculator = new YieldCalculator();

    private LottoConfig() {
    }

    private static InputView createInputView() {
        return inputView;
    }

    private static OutputView createOutputView() {
        return outputView;
    }

    private static LottoNumberParser createlottoNumberParser() {
        return lottoNumberParser;
    }

    private static AutoLottoGenerator createautoLottoGenerator() {
        return autoLottoGenerator;
    }

    private static LottoMatcher createlottoMatcher() {
        return lottoMatcher;
    }

    private static YieldCalculator createyieldCalculator() {
        return yieldCalculator;
    }

    public static LottoController lottoController() {
        return new LottoController(
                createInputView(),
                createOutputView(),
                createlottoNumberParser(),
                createautoLottoGenerator(),
                createlottoMatcher(),
                createyieldCalculator()
        );
    }
}
