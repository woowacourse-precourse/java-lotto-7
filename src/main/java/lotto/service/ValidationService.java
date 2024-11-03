package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoErrorMessages;
import lotto.view.LottoInfoMessages;

public class ValidationService {
    private ValidationService() {

    }

    public static ValidationService createValidationService() {
        return new ValidationService();
    }

    public int validatePayInput() {
        try {
            System.out.println(LottoInfoMessages.INSERT_PAY.text());
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.addErrorText());
            return validatePayInput();
        }
    }

    public int validateManualAmountIsInteger(int enableAmount) {
        try {
            System.out.println(LottoInfoMessages.INSERT_MANUAL_AMOUNT_START.text() + enableAmount
                    + LottoInfoMessages.INSERT_MANUAL_AMOUNT_END.text());
            int amount = Integer.parseInt(Console.readLine());
            amount = validateOverManualAmount(amount,enableAmount);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.addErrorText());
            return validateManualAmountIsInteger(enableAmount);
        }
    }

    public int validateOverManualAmount(int amount, int enableAmount) {
        if (amount > enableAmount || amount < 0) {
            System.out.println(LottoErrorMessages.NOT_ENABLE_AMOUNT_START.addErrorText()
                    + enableAmount + LottoErrorMessages.NOT_ENABLE_AMOUNT_END.text());
            return validateManualAmountIsInteger(enableAmount);
        }
        return amount;
    }
}

