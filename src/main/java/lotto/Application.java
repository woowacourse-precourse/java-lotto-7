package lotto;

import lotto.controller.LottoController;
import lotto.domain.DefaultLottoGenerator;
import lotto.domain.DefaultRankCalculationStrategy;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.domain.RankCalculator;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator();
        RankCalculator rankCalculator = new RankCalculator(new DefaultRankCalculationStrategy());
        LottoResultCalculator resultCalculator = new LottoResultCalculator(rankCalculator);

        LottoController controller = new LottoController(lottoGenerator, resultCalculator);

        controller.run();
    }
}
