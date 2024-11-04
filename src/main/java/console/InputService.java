package console;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    private static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        return money;
    }

    private static int convertToQuantity(int money) {
        int quantity = 0;

        if (money >= 1000) {
            quantity = money / 1000;
        }
        return quantity;
    }

    public static int lottoQuantity() {
        return convertToQuantity(getMoney());
    }
}
