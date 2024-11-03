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
        int pay = 0;
        try {
            System.out.println(LottoInfoMessages.INSERT_PAY.text());
            pay = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.text());
            validatePayInput();
        }
        return pay;
    }

    public int validateManualAmountIsInteger(int enableAmount) {
        int amount = 0;
        try {
            System.out.println(LottoInfoMessages.INSERT_MANUAL_AMOUNT_START.text());
            amount = Integer.parseInt(Console.readLine());
            validateOverManualAmount(amount, enableAmount);
        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.text());
            validateManualAmountIsInteger(enableAmount);
        }
        return amount;
    }

    private void validateOverManualAmount(int amount, int enableAmount) {
        if (amount > enableAmount || amount < 0) {
            System.out.println(LottoErrorMessages.NOT_ENABLE_AMOUNT_START.text()
                    + enableAmount + LottoErrorMessages.NOT_ENABLE_AMOUNT_END.text());
            validateManualAmountIsInteger(enableAmount);
        }
    }
}
