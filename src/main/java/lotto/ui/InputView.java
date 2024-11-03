package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ui.ViewConstant.*;

public class InputView {

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return input();
    }

    private String input() {
        return readLine().trim();
    }
}
