package lotto;

import lotto.controller.LottoController;
import lotto.io.Input;
import lotto.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();

        LottoController lottoController = new LottoController(output, input);
        lottoController.playLotto();
    }
}
