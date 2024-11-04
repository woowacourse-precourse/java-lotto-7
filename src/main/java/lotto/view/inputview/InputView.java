package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.error.ErrorMessage;
import lotto.message.info.InfoMessage;

public class InputView implements Input {
    @Override
    public int requestPurchaseAmount() {
        int purchaseAmount = -1;
        while (true) {
            try {
                System.out.println(InfoMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
                purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
        }
        return purchaseAmount;
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
