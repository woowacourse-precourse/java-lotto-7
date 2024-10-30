package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputMoney();
    }

    private static int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + " 구입 금액은 1,000원 단위여야 합니다.");
            }
        }
    }

    private static void validateMoney(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
