package lotto;

import lotto.Controller.LottoGameController;
import lotto.Factory.LottoDomainFactory;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        OutputView outputView = new OutputView();

        LottoDomainFactory lottoDomainFactory = new LottoDomainFactory();

        LottoService lottoService = new LottoService();

        LottoGameController lottoGameController = new LottoGameController(lottoService, inputView, outputView);

        lottoGameController.gameStart();
    }
}
