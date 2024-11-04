package lotto;

import lotto.util.InputHandler;

public class Application {
    public static void main(String[] args) {
        int money = InputHandler.getPurchaseAmount();
        int lottoCount = money / 1000;
    }
}
