package lotto.input;

import static lotto.enums.ErrorMessages.*;
import static lotto.enums.PromptMessages.PURCHASE_AMOUNT_PROMPT_MESSAGE;

public class PurchaseAmountValidator implements InputValidator<Integer, Void>{

    @Override
    public Integer validateInput(String input, Void unused) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            validateMinimumAmount(purchaseAmount);
            validateDivisibilityByThousand(purchaseAmount);

            return purchaseAmount;

        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }

    @Override
    public void displayPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MESSAGE.getMessage());
    }

    private void validateMinimumAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_BELOW_MINIMUM.getMessage());
        }
    }

    private void validateDivisibilityByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }
    }
}
