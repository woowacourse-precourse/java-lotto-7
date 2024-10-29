package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputMoney = getInputMoney();
        lotto Lotto = new Lotto();
    }

    private static String getInputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요. 단위는 1,000원입니다.");
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
            if (amount < 1000) {
                throw new IllegalArgumentException("구입금액은 1,000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자로 입력해 주세요.");
        }
    }
}
