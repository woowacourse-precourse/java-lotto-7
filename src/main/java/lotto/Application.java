package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoRankCalculator;
import lotto.model.ProfitCalculator;
import lotto.model.StatisticsGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        final StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottoRankCalculator);
        final ProfitCalculator profitCalculator = new ProfitCalculator();

        final LottoController lottoController = new LottoController(inputView, outputView, lottoNumberGenerator,
                lottoRankCalculator, statisticsGenerator, profitCalculator);

        lottoController.run();
    }
}
