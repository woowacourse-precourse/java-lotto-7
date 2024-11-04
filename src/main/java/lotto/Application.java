package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoStatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();
        LottoController lottoController = new LottoController(lottoService,lottoStatisticsService,inputView,outputView);
        lottoController.run();
    }
}
