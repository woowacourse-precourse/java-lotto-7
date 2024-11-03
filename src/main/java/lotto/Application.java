package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultFormatter;

public class Application {
    public static void main(String[] args) {
        
        ResultFormatter resultFormatter = new ResultFormatter();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoGameController lottoGameController = new LottoGameController(resultFormatter, inputView, outputView);
        lottoGameController.run();
    }
}
