package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.WinningNumbers;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.enums.NotificationMessage;

public class InputView {

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(NotificationMessage.PURCHASE_AMOUNT.getMessage());

                String purchaseInput = Console.readLine().trim();
                validateInteger(purchaseInput);
                int purchaseAmount = Integer.parseInt(purchaseInput);

                validatePurchaseAmount(purchaseAmount);

                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_AMOUNT.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int amount) {
        validatePositiveInteger(amount);
        validateOverPrice(amount);
        validateDivisibleByPrice(amount);
    }

    private static void validateDivisibleByPrice(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateOverPrice(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateInteger(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    private static void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    public static WinningNumbers getWinningNumbers() {
        return new WinningNumbers();
    }
}
