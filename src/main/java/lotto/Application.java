package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoFacade;
import lotto.service.LottoFacadeImpl;
import lotto.service.issuing.LottoIssuingService;
import lotto.service.issuing.LottoIssuingServiceImpl;
import lotto.service.prize.TotalPrizeCalculatorService;
import lotto.service.prize.TotalPrizeCalculatorServiceImpl;
import lotto.service.winningCheck.WinningCheckService;
import lotto.service.winningCheck.WinningCheckServiceImpl;
import lotto.service.winningStatistic.WinningStatisticService;
import lotto.service.winningStatistic.WinningStatisticServiceImpl;
import lotto.strategy.number.LottoNumberGeneratorStrategy;
import lotto.strategy.number.RandomLottoNumberGenerator;
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

        WinningCheckService winningCheckService = new WinningCheckServiceImpl();

        TotalPrizeCalculatorService totalPrizeCalculatorService = new TotalPrizeCalculatorServiceImpl(
                winningCheckService);

        WinningStatisticService winningStatisticService = new WinningStatisticServiceImpl(totalPrizeCalculatorService);

        LottoFacade lottoFacade = new LottoFacadeImpl(lottoIssuingService, winningStatisticService);

        LottoController lottoController = new LottoController(viewFacade, lottoFacade);
        lottoController.run();
    }
}
