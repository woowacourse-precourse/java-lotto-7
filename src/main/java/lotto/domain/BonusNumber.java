package lotto.domain;

import lotto.domain.validator.RangeValidator;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Integer number, RangeValidator rangeValidator) {
        validate(number, rangeValidator);
        this.number = number;
    }

    private void validate(Integer number, RangeValidator rangeValidator) {
        if (number == null) {
            throw new IllegalArgumentException("보너스 번호는 null 일 수 없습니다.");
        }

        if (rangeValidator.outOfRange(number)) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }

    public Integer getNumber() {
        return this.number;
    }
}
