package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static long getAmountFromUser() {
        OutputView.promptForAmount();
        String input = readLine();

        return StringParser.parseLong(input);
    }
}
