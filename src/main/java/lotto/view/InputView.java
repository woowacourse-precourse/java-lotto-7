package lotto.view;

import static lotto.constant.ErrorMessage.INPUT_EMPTY;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String read(String guideMessage) {
        System.out.println(guideMessage);
        String userInput = Console.readLine();
        validate(userInput);
        return userInput;
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY.getMessage());
        }
    }
}
