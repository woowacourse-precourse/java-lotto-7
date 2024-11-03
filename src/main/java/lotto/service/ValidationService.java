package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoErrorMessages;
import lotto.view.LottoInfoMessages;

public class ValidationService {
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

    private ValidationService() {

    }

    public static ValidationService createValidationService() {
        return new ValidationService();
    }
}
