package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getAmount() {
        return Console.readLine();
    }

    public String getWinningNumbers() {
        return Console.readLine();
    }

    public String getBonusNumber() {
        return Console.readLine();
    }
}
