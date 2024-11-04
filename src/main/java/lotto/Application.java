package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoManager;
import lotto.service.PrizeCalculator;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        LottoManager lottoManager = new LottoManager();
        PrizeCalculator prizeCalculator = new PrizeCalculator();

        LottoController lottoController = new LottoController(inputHandler, outputHandler, lottoManager, prizeCalculator);
        lottoController.run();
    }
}
