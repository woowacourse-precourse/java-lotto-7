package lotto.view;

import lotto.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readPrice() {
        String input = readConsole().trim();
        InputValidator.validatePrice(input);
        return Integer.parseInt(input);
    }

    private String readConsole() {
        return readLine();
    }
}
