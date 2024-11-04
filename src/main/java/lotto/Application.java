package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
