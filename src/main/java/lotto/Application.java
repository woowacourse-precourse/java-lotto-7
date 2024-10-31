package lotto;

import lotto.controller.LottoController;
import lotto.util.IntegerParser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController();
        controller.run();
    }
}
