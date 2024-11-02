package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();
        LottoController controller = new LottoController(input, output);
        controller.start();

    }
}
