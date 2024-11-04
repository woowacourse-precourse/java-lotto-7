package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.constants.ErrorMessages;

public class InputView {
    private InputView() {
    }

    public static String readInput() {
        String purchaseAmount = readLine().trim();

        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.formatMessage());
        }

        return purchaseAmount;
    }
}
