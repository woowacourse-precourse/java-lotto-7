package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {

    public int input() {
        while (true) {
            try {
                InputMessageEnum.PURCHASE_AMOUNT.printMessage();
                String purchaseAmount = readLine();
                int amount = parseAndValidateAmount(purchaseAmount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int parseAndValidateAmountForTest(String purchaseAmount) {
        return parseAndValidateAmount(purchaseAmount);
    }

    private int parseAndValidateAmount(String purchaseAmount) {
        try {
            int amount = Integer.parseInt(purchaseAmount);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException(
                    InputMessageEnum.INVALID_AMOUNT_ERROR.getMessage());
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_AMOUNT_ERROR.getMessage());
        }
    }
}