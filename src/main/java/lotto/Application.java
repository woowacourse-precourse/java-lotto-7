package lotto;

import lotto.controller.LottoController;
import lotto.io.Input;
import lotto.io.Output;
import lotto.util.Validator;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        Validator validator = new Validator();

        LottoController lottoController = new LottoController(output, input, validator);
        lottoController.playLotto();
    }
}
