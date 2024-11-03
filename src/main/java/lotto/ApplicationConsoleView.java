package lotto;

import static lotto.ConsoleMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationConsoleView implements ApplicationView {

    @Override
    public int requestMoney() {
        println(REQUEST_INPUT_MONEY);
        return Integer.parseInt(Console.readLine());
    }

    private void println(String message) {
        System.out.println(message);
    }
}
