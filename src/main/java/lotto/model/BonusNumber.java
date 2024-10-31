package lotto.model;

import lotto.exception.GameException;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < LottoOption.MIN_NUMBER_OF_RANGE.value() || number > LottoOption.MAX_NUMBER_OF_RANGE.value()) {
            throw new GameException("보너스 번호는 %d부터 %d사이여야 합니다.".formatted(LottoOption.MIN_NUMBER_OF_RANGE.value(), LottoOption.MAX_NUMBER_OF_RANGE.value()));
        }
    }

}
