package lotto;

import lotto.handler.MoneyInputHandler;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long lottoCount = moneyInputHandler.getLottoCount();
        System.out.println("로또 개수 = " + lottoCount);
    }
}
