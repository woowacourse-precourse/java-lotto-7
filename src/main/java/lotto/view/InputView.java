package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchaseAmountException;

import static lotto.exception.ErrorMessage.INVALID_NUMBER_FORMAT;

public class InputView {
    public int getPurchaseAmount() {
        int purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");

        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
