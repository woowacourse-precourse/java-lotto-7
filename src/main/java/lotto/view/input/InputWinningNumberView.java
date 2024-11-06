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

        return validate(input);
    }

    private static Set<Integer> validate(String[] input) {
        countValidation(input);

        Set<Integer> winningNumbers = new HashSet<>();
        for (String str : input) {
            winningNumbers.add(rangeValidation(str));
        }
        duplicationValidation(winningNumbers);

        return winningNumbers;
    }

    private static void countValidation(String[] input) {
        if (input.length != 6) {
            throw new WinningNumberCountException();
        }
    }

    private static void duplicationValidation(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new WinningNumberDuplicationException();
        }
    }

    private static int rangeValidation(String input) {
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
