package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputHandler {
    private final Validator validator;

    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public String getInputForPurchaseMoney() {
        String input = Console.readLine();
        validator.checkPurchaseMoney(input);
        return input;
    }

    public String getInputForWinnerNumber() {
        String input = Console.readLine();
        validator.checkLottoNumbers(input);
        return input;
    }
}
