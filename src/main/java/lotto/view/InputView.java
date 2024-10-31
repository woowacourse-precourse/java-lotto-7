package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();

    public String getMoney() {
        outputView.printMoneyRequest();
        return Console.readLine();
    }
}
