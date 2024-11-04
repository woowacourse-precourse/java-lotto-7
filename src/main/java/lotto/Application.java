package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResultCalculator;
import lotto.domain.generator.DefaultLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.strategy.DefaultRankCalculationStrategy;
import lotto.domain.strategy.RankCalculator;
import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator();
        RankCalculator rankCalculator = new RankCalculator(new DefaultRankCalculationStrategy());
        LottoResultCalculator resultCalculator = new LottoResultCalculator(rankCalculator);

        LottoService lottoService = new LottoService(lottoGenerator, resultCalculator);

        LottoController controller = new LottoController(lottoService);

        controller.run();
    }
}
