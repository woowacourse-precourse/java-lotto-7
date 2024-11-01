package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.PurchaseAmountFormatException;
import lotto.exception.PurchaseAmountTypeException;
import lotto.exception.PurchaseAmountZeroException;

public class InputPurchaseAmoutVIew {
    public static int purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = validate(input);

        return purchaseAmount;
    }

    private static int validate(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount <= 0) {
                throw new PurchaseAmountZeroException();
            }
            if (purchaseAmount % 1000 != 0) {
                throw new PurchaseAmountFormatException();
            }

            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new PurchaseAmountTypeException();
        }
    }
}
