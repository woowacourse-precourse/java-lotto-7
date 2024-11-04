package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.value.Money;
import lotto.lotto.value.WinningNumber;

import java.util.Arrays;
import java.util.List;

public final class InputReader {

    private InputReader() {
    }

    public static Money readMoney() {
        while (true) {
            try {
                return new Money(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumber readWinningNumber() {
        while (true) {
            try {
                String textValue = Console.readLine();
                List<Integer> winningValues = Arrays.stream(textValue.split(","))
                        .map(Integer::parseInt)
                        .toList();
                return new WinningNumber(winningValues);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 다시 입력하세요.");
            }
        }
    }

    public static int readBonus() {
        while (true) {
            try {
                String bonusValue = Console.readLine();
                return Integer.parseInt(bonusValue);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 다시 입력하세요.");
            }
        }
    }
}
