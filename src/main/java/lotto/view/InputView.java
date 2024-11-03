package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Amount;

public class InputView {

    public static Amount inputAmount() {
        Amount amount = null;
        while (amount == null) {
            try {
                String input = Console.readLine();
                amount = new Amount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }
}
