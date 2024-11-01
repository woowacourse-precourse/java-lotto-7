package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateInputInteger(purchaseAmount);
    }

    public static void validateInputInteger(String inputInteger) {
        if (inputInteger == null
                || inputInteger.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
        if (!inputInteger.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (inputInteger.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }
}
