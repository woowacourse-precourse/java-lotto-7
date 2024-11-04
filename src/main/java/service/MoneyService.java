package service;

import camp.nextstep.edu.missionutils.Console;
import object.Money;

public class MoneyService {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public int convertQuantity(Money money) {
        int quantity = 0;

        if (money.getMoney() >= 1000) {
            quantity = money.getMoney() / 1000;
        }
        return quantity;
    }

}
