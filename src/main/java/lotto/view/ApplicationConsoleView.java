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

    private void println(String message) {
        System.out.println(message);
    }
}
