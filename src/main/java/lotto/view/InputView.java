package lotto.view;

import lotto.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = readConsole();
            try {
                InputValidator.validatePrice(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readConsole() {
        return readLine();
    }
}
