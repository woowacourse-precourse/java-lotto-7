package lotto;

import lotto.config.LottoGameConfig;
import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGameConfig gameConfig = new LottoGameConfig(
                new InputView(),
                new OutputView()
        );
        LottoGameController controller = new LottoGameController(gameConfig);

        controller.control();
    }
}
