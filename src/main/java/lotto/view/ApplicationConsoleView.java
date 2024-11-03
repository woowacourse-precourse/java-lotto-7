package lotto.view;

import static lotto.common.ConsoleMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ApplicationConsoleView implements ApplicationView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public int requestMoney() {
        println(REQUEST_INPUT_MONEY);
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public void printPurchasedLotto(List<String> lottos) {
        println(LINE_SEPARATOR + lottos.size() + PURCHASE_COUNT_MESSAGE);
        lottos.forEach(this::println);
    }

    @Override
    public String requestWinNumber() {
        println(REQUEST_INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    @Override
    public int requestBonusNumber() {
        println(REQUEST_INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    private void println(String message) {
        System.out.println(message);
    }
}
