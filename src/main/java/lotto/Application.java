package lotto;

import lotto.handler.MoneyInputHandler;

import static lotto.view.RequestView.getMoney;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long lottoCount = moneyInputHandler.getLottoCount(getMoney());
        System.out.println("로또 개수 = " + lottoCount);
    }
}
