package lotto;

import lotto.io.InputView;

public class GameManager {
    private InputView inputView;

    public GameManager() {
        inputView = new InputView();
    }

    public void start() {
        int price = readPrice();
    }

    private int readPrice() {
        return Integer.parseInt(inputView.readPrice());
    }
}

