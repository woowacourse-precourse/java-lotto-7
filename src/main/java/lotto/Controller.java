package lotto;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    public void run() {
        int lottoPrice = inputHandler.getLottoPrice();
    }

}
