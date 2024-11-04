package lotto.domain;

import lotto.service.Validator;

import java.util.List;

public class BonusNumber {
    private final Validator validator = new Validator();
    private final int number;

    public BonusNumber(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    private void validate(int number, List<Integer> numbers) {
        validator.validateNumberInRange(number);
        for(int winningNumber : numbers) {
            validator.validateBonusNumberDuplicate(number, winningNumber);
        }
    }

    public int getNumber() {
        return number;
    }
}
