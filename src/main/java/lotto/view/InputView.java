package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class InputView {
    public String readLine() {
        String readLine = Console.readLine();
        return readLine.trim();
    }
}
