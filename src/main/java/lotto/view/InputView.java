package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ErrorMessage.*;

public class InputView {

    public int insertNumber() {
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_FORMAT.getMessage(), e);
        }
    }

    public String insertLetter() {
        return Console.readLine();
    }
}
