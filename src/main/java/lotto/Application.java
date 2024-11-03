package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 1.5 형식에 맞는 구입 금액이 입력될 때까지 반복하여 입력을 받는 기능
        int purchaseAmount = getPurchaseAmount();


    }

    private static String getInputString(String message) {
        System.out.println(message);
        return Console.readLine();
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

    private static int getPurchaseAmount() {
        while (true) {
            String purchaseAmountInput = getInputString("구입 금액을 입력해 주세요.");
            try {
                return convertPurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int convertPurchaseAmount(String purchaseAmountInput) {
        validateNumericString(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validatePositiveNumber(purchaseAmount);
        validateThousandUnit(purchaseAmount);
        return purchaseAmount;
    }


}
