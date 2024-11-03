package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoController;
import lotto.service.LottoFacade;
import lotto.service.LottoFacadeImpl;
import lotto.service.issuing.LottoIssuingService;
import lotto.service.issuing.LottoIssuingServiceImpl;
import lotto.service.statistic.StatisticService;
import lotto.service.statistic.StatisticServiceImpl;
import lotto.service.statistic.prize.PrizeCalculatorService;
import lotto.service.statistic.prize.PrizeCalculatorServiceImpl;
import lotto.strategy.number.LottoNumberGeneratorStrategy;
import lotto.strategy.number.RandomLottoNumberGenerator;
import lotto.strategy.prize.FifthPrizeStrategy;
import lotto.strategy.prize.FirstPrizeStrategy;
import lotto.strategy.prize.FourthPrizeStrategy;
import lotto.strategy.prize.PrizeFacade;
import lotto.strategy.prize.PrizeStrategy;
import lotto.strategy.prize.SecondPrizeStrategy;
import lotto.strategy.prize.ThirdPrizeStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ViewFacade;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ViewFacade viewFacade = new ViewFacade(inputView, outputView);

        LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy = new RandomLottoNumberGenerator();
        LottoIssuingService lottoIssuingService = new LottoIssuingServiceImpl(lottoNumberGeneratorStrategy);

        PrizeStrategy fifthPrizeStrategy = new FifthPrizeStrategy();
        PrizeStrategy fourthPrizeStrategy = new FourthPrizeStrategy();
        PrizeStrategy thirdPrizeStrategy = new ThirdPrizeStrategy();
        PrizeStrategy secondPrizeStrategy = new SecondPrizeStrategy();
        PrizeStrategy firstPrizeStrategy = new FirstPrizeStrategy();

        List<PrizeStrategy> prizeStrategies = Arrays.asList(
                fifthPrizeStrategy,
                fourthPrizeStrategy,
                thirdPrizeStrategy,
                secondPrizeStrategy,
                firstPrizeStrategy
        );

        PrizeFacade prizeFacade = new PrizeFacade(prizeStrategies);
        PrizeCalculatorService prizeCalculatorService = new PrizeCalculatorServiceImpl(prizeFacade);

        StatisticService statisticService = new StatisticServiceImpl(prizeCalculatorService);

        LottoFacade lottoFacade = new LottoFacadeImpl(lottoIssuingService, statisticService);

        LottoController lottoController = new LottoController(viewFacade, lottoFacade);
        lottoController.run();
    }
}
