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
                || inputInteger.isBlank()
                || !inputInteger.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }
}
