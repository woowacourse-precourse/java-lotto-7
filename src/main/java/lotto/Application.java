package lotto;

import lotto.handler.MoneyInputHandler;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long money = moneyInputHandler.readMoney();
        System.out.println("money = " + money);
    }
}
