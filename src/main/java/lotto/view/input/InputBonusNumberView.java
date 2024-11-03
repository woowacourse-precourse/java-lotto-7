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

        if (input.length != 1) {
            throw new BonusNumberCountException();
        }

        int bonusNumber = validate(input[0]);

        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicationException();
        }

        return bonusNumber;
    }

    private static int validate(String input) {
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
