package lotto.input;

import static lotto.constants.ErrorMessage.INPUT_MUST_BE_NUMBER;
import static lotto.constants.InputPrompts.ENTER_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static Purchase getPurchaseAmount() {
        while (true) {
            System.out.println(ENTER_PURCHASE_AMOUNT.getPrompt());

            try {
                return new Purchase(Integer.parseInt(Console.readLine()));
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MUST_BE_NUMBER.getMessage());
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
