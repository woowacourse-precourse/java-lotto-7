package lotto.service;

import static lotto.view.exception.ErrorMessage.MultipleOfThousand;
import static lotto.view.exception.ErrorMessage.numberFormat;

public class Purchase {

    private final int purchaseAccount;

    public Purchase(String purchaseAccount) {
        validate(purchaseAccount);
        this.purchaseAccount = Integer.parseInt(purchaseAccount) / 1000;
    }

    private void validate(String purchaseAccount) {
        checkNumeric(purchaseAccount);
        checkMultipleOfThousand(purchaseAccount);
    }

    private void checkNumeric(String purchaseAccount) {
        try {
            Integer.parseInt(purchaseAccount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(numberFormat);
        }
    }

    private void checkMultipleOfThousand(String purchaseAccount) {
        int amount = Integer.parseInt(purchaseAccount);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(MultipleOfThousand);
        }
    }

    public int getPurchaseAccount() {
        return purchaseAccount;
    }


}
