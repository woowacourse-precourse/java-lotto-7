package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants;
import lotto.Utils;

public class LottoWinningNumberValidator {
    public final String winningNumbersBeforeValidate;
    public List<Integer> winningNums;

    public LottoWinningNumberValidator(String input) {
        this.winningNumbersBeforeValidate = input;
        this.winningNums = new ArrayList<>();
        validate();
    }

    private void validate() {
        validateBlank();
        validatePattern();
        validateRange();
        validateSize();
        validateDuplicate();
    }

    private void validateSize() {
        if (this.winningNums.size() != 6) {
            System.out.println(Constants.WINNING_NUMS_SIZE_ERROR);
            throw new IllegalArgumentException(Constants.WINNING_NUMS_SIZE_ERROR);
        }
    }

    private void validateDuplicate() {
        if (this.winningNums.size() != this.winningNums.stream().distinct().count()) {
            System.out.println(Constants.WINNING_NUMS_DUPLICATE_ERROR);
            throw new IllegalArgumentException(Constants.WINNING_NUMS_DUPLICATE_ERROR);
        }
    }

    private void validateBlank() {
        if (this.winningNumbersBeforeValidate.isBlank() || this.winningNumbersBeforeValidate.isEmpty()) {
            System.out.println(Constants.WINNING_NUMS_INPUT_BLANK_ERROR);
            throw new IllegalArgumentException(Constants.WINNING_NUMS_INPUT_BLANK_ERROR);
        }
    }

    private void validatePattern() {
        if (!Constants.winningNumsPattern.matcher(winningNumbersBeforeValidate).matches()) {
            System.out.println(Constants.WINNING_NUMS_PARSING_ERROR);
            throw new IllegalArgumentException(Constants.WINNING_NUMS_PARSING_ERROR);
        }
        this.winningNums = Utils.toArrayList(this.winningNumbersBeforeValidate);
    }

    private void validateRange() {
        if (winningNums.stream().anyMatch(num -> num < Constants.MIN_RANGE || num > Constants.MAX_RANGE)) {
            System.out.println(Constants.WINNING_NUMS_RANGE_ERROR);
            throw new IllegalArgumentException(Constants.WINNING_NUMS_RANGE_ERROR);
        }
    }
}
