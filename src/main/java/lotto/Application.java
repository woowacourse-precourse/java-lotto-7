package lotto;

import lotto.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputHandler inputHandler = new InputHandler();
        LottoManager lottoManager = new LottoManager(inputHandler);

        lottoManager.manageLotto();
    }
}
