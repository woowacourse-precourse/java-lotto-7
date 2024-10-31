package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return processPurchaseAmount();
    }

    private static int processPurchaseAmount() {
        try {
            String amount = Console.readLine().trim();
            validatePurchaseAmount(amount);
            return Integer.parseInt(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private static void validatePurchaseAmount(String amount) {
        InputValidator.validateNotBlank(amount);
        InputValidator.validateInteger(amount);
        InputValidator.validateThousandUnit(Integer.parseInt(amount));
    }
}
