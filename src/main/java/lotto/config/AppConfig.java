package lotto.config;

import lotto.controller.LottoGameController;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.util.LottoTicketGenerator;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public static LottoGameController createLottoGameController() {
        LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        LottoService lottoService = new LottoService(ticketGenerator, prizeCalculator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ErrorView errorView = new ErrorView();

        return new LottoGameController(lottoService, inputView, errorView, outputView);
    }

}
