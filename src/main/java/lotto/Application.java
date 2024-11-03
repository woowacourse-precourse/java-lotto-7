package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 1.1 로또 구입 금액을 입력 받는 기능
        System.out.println("구입 금액을 입력해 주세요.");
        String purchaseAmountInput = Console.readLine();

        try {
            // 1.2 입력된 구입 금액을 정수로 변환할 수 없는 경우 예외 처리하는 기능
            validateNumericString(purchaseAmountInput);
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            // 1.3 구입 금액이 양수가 아닌 경우 예외 처리하는 기능
            validatePositiveNumber(purchaseAmount);
            // 1.4 구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 처리하는 기능
            validateThousandUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 문자열입니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않는 금액입니다.");
        }
    }

}
