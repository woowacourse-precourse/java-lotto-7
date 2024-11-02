package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputMoney = getInputMoney();
        buyLotto(Integer.parseInt(inputMoney));
    }

    private static String getInputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateMoney(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException("구입금액은 필수입니다.");
        }
        try {
            int amount = Integer.parseInt(money);
            if (amount < 1000 || !checkUnitMoney(amount)) {
                throw new IllegalArgumentException("구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자로 입력해 주세요.");
        }
    }

    private static boolean checkUnitMoney(int money) {
        return money % 1000 == 0;
    }

    private static void buyLotto(int money) {
        int count = money / 1000;
        System.out.println(count + "개를 구매하였습니다.");
    }
}
