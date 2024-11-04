package lotto.domain;

import java.util.List;
import lotto.validator.RangeValidator;
import lotto.validator.SizeValidator;
import lotto.validator.DuplicationValidator;

public class BonusNumberOfUser {
    private final List<Integer> number;

    public BonusNumberOfUser(List<Integer> number) {
        RangeValidator.validate(number);
        SizeValidator.validate(number);
        DuplicationValidator.validate(number);
        this.number = number;
    }
}