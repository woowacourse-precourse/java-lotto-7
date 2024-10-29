package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputHandler {
    private final Validator validator;

    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public String getInputForPurchaseMoney() {
        while (true) {
            try {
                String input = Console.readLine();
                validator.checkPurchaseMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public String getInputForWinningNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                validator.checkLottoNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
