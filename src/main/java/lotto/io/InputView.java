package lotto.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readPrice() {
        return readLine();
    }

    public String[] readWinningNumber() {
        return readLine().split(",");
    }

    public String readBonusNumber() {
        return readLine();
    }
}
