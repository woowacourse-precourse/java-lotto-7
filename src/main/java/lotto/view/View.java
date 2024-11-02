package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int inputLottoPurchaseAmount() {
        String amountInput = Console.readLine();
        validatePurchaseAmount(amountInput);
        return Integer.parseInt(amountInput);
    }

    private static void validatePurchaseAmount(String inputValue) {
        validateNumeric(inputValue);
        validateEmpty(inputValue);

    }

    private static void validateEmpty(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }


}
