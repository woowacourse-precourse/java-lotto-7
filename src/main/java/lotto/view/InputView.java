package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMoney() {
        return Console.readLine();
    }

    public String getWinningNumber() {
        return Console.readLine();
    }

    public String getBonusNumber() {
        return Console.readLine();
    }
}
