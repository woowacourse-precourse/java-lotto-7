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
        int count = countLotto(money);
        outputCount(count);
    }

    private static int getMoney() {
        System.out.println("로또 구매 금액을 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void exception (int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액이 0보다 커야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 금액이 1개당 1000원이므로 1000원 단위로 입력하세요.");
        }
    }

    private static int countLotto(int money) {
        return money / 1000;
    }

    private static void outputCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
