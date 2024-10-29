package lotto;

import lotto.io.InputHandler;

public class Controller {
    private final InputHandler inputHandler = new InputHandler();
    public void run() {
        int lottoPrice = inputHandler.getLottoPrice();
        int lottoCount = lottoPrice / 1000;
    }

}
