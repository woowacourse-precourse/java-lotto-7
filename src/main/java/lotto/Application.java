package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        try {
            InputView input = new InputView();
            OutputView output = new OutputView();
            LottoController controller = new LottoController(input, output);
            controller.start();
            controller.checkLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }
}
