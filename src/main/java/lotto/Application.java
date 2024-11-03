package lotto;

import lotto.controller.LottoController;
import lotto.model.AutoLottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.YieldCalculator;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoNumberParser lottoNumberParser = new LottoNumberParser();
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        LottoMatcher lottoMatcher = new LottoMatcher();
        YieldCalculator yieldCalculator = new YieldCalculator();

        LottoController lottoController = new LottoController(inputView, outputView,
                lottoNumberParser, autoLottoGenerator,
                lottoMatcher, yieldCalculator);

        lottoController.run();
    }
}
