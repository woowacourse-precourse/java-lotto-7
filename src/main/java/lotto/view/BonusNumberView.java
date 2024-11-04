package lotto.view;

import lotto.error.Error;

import java.util.List;

public class BonusNumberView extends InputView {

    private final List<Integer> winningNumbers;

    public BonusNumberView(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(Error.DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
            }

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
        }
    }
}