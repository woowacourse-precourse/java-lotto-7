package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String userInput() {
        String input = Console.readLine();
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
        return input;
    }
}
