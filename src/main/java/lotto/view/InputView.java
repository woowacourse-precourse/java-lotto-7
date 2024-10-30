package lotto.view;

import lotto.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readConsole().trim();
        InputValidator.validatePrice(input);
        return Integer.parseInt(input);
    }

    private String readConsole() {
        return readLine();
    }
}
