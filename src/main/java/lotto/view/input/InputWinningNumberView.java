package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
import lotto.exception.WinningNumberCountException;
import lotto.exception.WinningNumberDuplicationException;
import lotto.exception.WinningNumberRangeException;
import lotto.exception.WinningNumberTypeException;

public class InputWinningNumberView {
    public static Set<Integer> WinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        System.out.println();

        Set<Integer> winningNumbers = new HashSet<>();

        if (input.length != 6) {
            throw new WinningNumberCountException();
        }

        for (String str : input) {
            winningNumbers.add(validate(str));
        }

        if (winningNumbers.size() != 6) {
            throw new WinningNumberDuplicationException();
        }

        return winningNumbers;
    }

    private static int validate(String input) {
        try {
            int winningNumber = Integer.parseInt(input);
            if (winningNumber <= 0 || winningNumber > 45) {
                throw new WinningNumberRangeException();
            }

            return winningNumber;
        } catch (NumberFormatException e) {
            throw new WinningNumberTypeException();
        }
    }
}
