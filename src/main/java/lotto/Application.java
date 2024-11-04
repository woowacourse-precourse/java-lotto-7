package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int money = getInputMoney();
    }

    public static int getInputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                validateInputMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void validateInputMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }


}
