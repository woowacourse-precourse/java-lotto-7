package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        inputMoney();

    }

    public static void inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Long money = Long.parseLong(Console.readLine());
        if (!validMoney(money)) {
            inputMoney();
        }
    }

    public static boolean validMoney(Long money) {
        return money % 1000 == 0;
    }
}
