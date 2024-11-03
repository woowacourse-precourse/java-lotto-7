package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView() {
    }

    public String inputCash() {
        return Console.readLine();
    }

    public String inputWinningNumber() {
        return Console.readLine();
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}
