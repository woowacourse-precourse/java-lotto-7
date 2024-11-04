package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ConstraintConstants;
import lotto.constants.ErrorViewConstants;
import lotto.constants.InputViewConstants;

import static lotto.service.ValidatorService.validatePurchaseAmount;

public class InputService {
    public int getPurchaseAmount() {
        System.out.println(InputViewConstants.PURCHASE_AMOUNT_INSTRUCTION);
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (validatePurchaseAmount(purchaseAmount)) {
                return purchaseAmount / ConstraintConstants.PURCHASE_UNIT;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorViewConstants.INVALID_INPUT_TYPE);
        }
        throw new IllegalArgumentException(ErrorViewConstants.INVALID_INPUT_CONSTRAINT);
    }

}
