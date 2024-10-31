package view;

import static exception.ErrorMessage.PURCHASE_PRICE_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CHECK_NUMBER_REGEX = "\\d+";

    private InputView() {
    }

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";

    public static void purchasePriceInput() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String userInput = Console.readLine();
        validatePurchasePrice(userInput);
    }

    private static void validatePurchasePrice(String purchasePrice) {
        if (!purchasePrice.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ONLY_NUMBER.getMessage());
        }
    }


}
