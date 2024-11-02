package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static long getAmountFromUser() {
        OutputView.promptForAmount();
        String input = readLine();

        try {
            return Long.parseLong(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 바꿀 수 없음.");
        }
    }
}
