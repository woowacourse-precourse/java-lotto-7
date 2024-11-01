package lotto.Model;

import java.util.List;
import lotto.Constants;

public class BonusNumValidator {
    public final String bonusNumBeforeValidate;
    public int bonusNum;

    public BonusNumValidator(String input, List<Integer> winNums) {
        this.bonusNumBeforeValidate = input;
        validate(winNums);
    }

    private void validate(List<Integer> winNums) {
        validateBlank();
        validatePattern();
        validateRange();
        validateDuplicate(winNums);
    }

    private void validateBlank() {
        if (this.bonusNumBeforeValidate.isBlank() || this.bonusNumBeforeValidate.isEmpty()) {
            System.out.println(Constants.BONUS_NUM_BLANK_ERROR);
            throw new IllegalArgumentException(Constants.BONUS_NUM_BLANK_ERROR);
        }
    }

    private void validatePattern() {
        if (!Constants.winningNumsPattern.matcher(this.bonusNumBeforeValidate).matches()) {
            System.out.println(Constants.BONUS_NUM_PARSE_ERROR);
            throw new IllegalArgumentException(Constants.BONUS_NUM_PARSE_ERROR);
        }
    }

    private void validateRange() {
        if (Integer.parseInt(this.bonusNumBeforeValidate) < Constants.MIN_RANGE
                || Integer.parseInt(this.bonusNumBeforeValidate) > Constants.MAX_RANGE) {
            System.out.println(Constants.BONUS_NUM_RANGE_ERROR);
            throw new IllegalArgumentException(Constants.BONUS_NUM_RANGE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> winNums) {
        for (Integer winNum : winNums) {
            if (winNum == Integer.parseInt(this.bonusNumBeforeValidate)) {
                System.out.println(Constants.BONUS_NUM_DUPLICATE_ERROR);
                throw new IllegalArgumentException(Constants.BONUS_NUM_DUPLICATE_ERROR);
            }
        }

        this.bonusNum = Integer.parseInt(this.bonusNumBeforeValidate);
    }
}
