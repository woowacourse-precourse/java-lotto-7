package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();
        System.out.println("구입 금액 : " + money);
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        errorMoney(amount);
        return amount;
    }

    private static void errorMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
