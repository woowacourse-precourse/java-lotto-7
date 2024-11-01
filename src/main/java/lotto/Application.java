package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.util.Parser;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();
        Parser parser = new Parser();
        LottoController lottoController = new LottoController(inputView, lottoMachine, parser);

        lottoController.run();
    }
}
