package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.Money;
import lotto.lotto.WinningNumber;

import java.util.Arrays;
import java.util.List;

public final class InputReader {

    private InputReader() {
    }

    public static Money readMoney() {
        String moneyValue = Console.readLine();
        return new Money(moneyValue);
    }

    public static WinningNumber readWinningNumber() {
        String textValue = Console.readLine();
        List<Integer> winningValues = Arrays.stream(textValue.split(","))
                .map(Integer::parseInt)
                .toList();
        return new WinningNumber(winningValues);
    }

    public static int readBonus() {
        String bonusValue = Console.readLine();
        return Integer.parseInt(bonusValue);
    }
}
