package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

import lotto.exception.ExceptionMessage;

public class InputView {
    public int inputNumber() {
        while (true) {
            String input = readLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }
}
