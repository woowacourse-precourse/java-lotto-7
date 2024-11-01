package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class WinningLotto extends Lotto {
    private int bonusNum;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        super(nums);
        this.bonusNum = bonusNum;
        //validate();
    }

    public static WinningLotto create(String winningNumber) {
        validateWinningNumber(winningNumber);
        return null;
    }

    private static void validateWinningNumber(String winningNumber) {
        Validator.isEmptyInput(winningNumber);
    }
}
