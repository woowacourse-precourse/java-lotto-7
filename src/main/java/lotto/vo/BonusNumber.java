package lotto.vo;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        // TODO: 에러 발생
    }
}
