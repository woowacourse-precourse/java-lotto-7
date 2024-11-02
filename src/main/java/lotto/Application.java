package lotto;

import lotto.controller.LottoController;
import lotto.handler.InputHandler;
import lotto.handler.LottoHandler;
import lotto.handler.OutputHandler;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new InputHandler(), new OutputHandler(), new LottoHandler());

        controller.lottoStart();
    }
}
