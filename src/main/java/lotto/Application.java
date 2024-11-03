package lotto;

import lotto.controller.LottoController;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        LottoController lottoController = new LottoController(inputReader,outputWriter);

        lottoController.startLotto();
    }
}
