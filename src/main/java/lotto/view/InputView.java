package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputLottoCost() {
        return readConsoleInput();
    }

    public String inputWinningNumbers(){
        return  readConsoleInput();
    }


    private String readConsoleInput() {
        return Console.readLine();
    }
}