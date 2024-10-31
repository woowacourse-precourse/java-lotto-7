package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;

        while (true) {
            try {
                money = getMoney();
                exception(money);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }
    }

    private static int getMoney() {
        System.out.println("로또 구매 금액을 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
