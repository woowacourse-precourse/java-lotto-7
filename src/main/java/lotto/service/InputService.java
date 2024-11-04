package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ConstraintConstants;
import lotto.constants.InputViewConstants;

public class InputService {
    public int getPurchaseAmount() {
        System.out.println(InputViewConstants.PURCHASE_AMOUNT_INSTRUCTION);
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (validatePurchaseAmount(purchaseAmount)) {
                return purchaseAmount / ConstraintConstants.PURCHASE_UNIT;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private boolean validatePurchaseAmount(int purchaseAmount) {
        return purchaseAmount % ConstraintConstants.PURCHASE_UNIT == 0
                && purchaseAmount <= ConstraintConstants.MAX_PURCHASE_AMOUNT;
    }
}
