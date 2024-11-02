package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {

    public int input() {
        while (true) {
            try {
                InputMessageEnum.PURCHASE_AMOUNT.printMessage();
                String purchaseAmount = readLine();
                int amount = Integer.parseInt(purchaseAmount);
                validatePurchaseAmount(amount);
                return amount;
            } catch (Exception e) {
                handleInputException(e);
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_AMOUNT_ERROR.getMessage());
        }
    }

    private void handleInputException(Exception e) {
        if (e instanceof NumberFormatException) {
            System.out.println(InputMessageEnum.INVALID_AMOUNT_ERROR.getMessage());
        }
        if (e instanceof IllegalArgumentException) {
            System.out.println(e.getMessage());
        }
    }
}