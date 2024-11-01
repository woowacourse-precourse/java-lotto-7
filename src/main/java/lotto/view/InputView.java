package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.ErrorMessageConstant.NON_NUMERIC_MESSAGE;

public class InputView {
    private InputView(){
    }

    public static int getPurchase() {
        String purchase = readLine();
        validateNumericInput(purchase);
        return Integer.parseInt(purchase);
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }
}
