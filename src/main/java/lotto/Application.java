package lotto;

import lotto.controller.LottoController;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Input input = new InputView();
        Output output = new OutputView();

        LottoController controller = new LottoController(input, output);
        controller.run();
    }
}
