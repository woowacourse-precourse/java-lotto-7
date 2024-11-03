package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Spliter.splitWinningNumbers;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static String getUserInput() {
        return readLine();
    }

    public static List<String> getUserInputByList() {
        String winningNumbers = readLine();
        return splitWinningNumbers(winningNumbers);
    }
}
