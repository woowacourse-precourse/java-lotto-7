package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static final String INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String INVALID_MONEY_FORMAT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                var moneyInput = Console.readLine();
                var purchaseMoney = validateIntegerInput(moneyInput);
                validatePurchaseMoney(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // TODO: 추가 기능 구현
    }

    public static Integer validateIntegerInput(String input) {
        try {
            var number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validatePurchaseMoney(Integer purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_FORMAT_MESSAGE);
        }
    }
}
