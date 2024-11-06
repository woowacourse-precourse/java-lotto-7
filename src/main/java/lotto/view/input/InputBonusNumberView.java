package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import lotto.exception.BonusNumberCountException;
import lotto.exception.BonusNumberDuplicationException;
import lotto.exception.BonusNumberRangeException;
import lotto.exception.BonusNumberTypeException;

public class InputBonusNumberView {
    public static int bonusNumberInput(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",| ");
        System.out.println();

        return validate(input, winningNumbers);
    }

    private static int validate(String[] input, Set<Integer> winningNumbers) {
        countValidation(input);
        int bonusNumber = rangeValidation(input[0]);
        duplicationValidation(winningNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void countValidation(String[] input) {
        if (input.length != 1) {
            throw new BonusNumberCountException();
        }
    }

    private static void duplicationValidation(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicationException();
        }
    }

    private static int rangeValidation(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber <= 0 || bonusNumber > 45) {
                throw new BonusNumberRangeException();
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new BonusNumberTypeException();
        }
    }
}
