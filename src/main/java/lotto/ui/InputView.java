package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int inputMoney() {
        String money = input();
        return Integer.parseInt(money);
    }

    private String input() {
        return readLine().trim();
    }
}
