package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            String inputMoney = getInputMoney();
            buyLotto(Integer.parseInt(inputMoney));
        } catch (Exception e) {
            System.out.println("[ERROR] 예상치 못한 오류가 발생했습니다.");
        } finally {
            Console.close();
        }
    }

    private static String getInputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateMoney(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 필수입니다.");
        }
        try {
            int amount = Integer.parseInt(money);
            if (amount < LOTTO_PRICE || !checkUnitMoney(amount)) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요.");
        }
    }

    private static boolean checkUnitMoney(int money) {
        return money % LOTTO_PRICE == 0;
    }

    private static void buyLotto(int money) {
        int count = money / LOTTO_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            System.out.println(lotto);
        }
    }
}