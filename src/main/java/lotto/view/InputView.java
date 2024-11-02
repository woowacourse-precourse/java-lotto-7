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

                int purchaseAmount = Integer.parseInt(Console.readLine().trim());

                validatePurchaseAmount(purchaseAmount);

                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_AMOUNT.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE.getValue() != 0 || amount < LottoConstants.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    public static WinningNumbers getWinningNumbers() {
        return new WinningNumbers();
    }
}
