package lotto.domain;

public class BonusNumber {

    private final Integer num;

    public BonusNumber(int num) {
        validate(num);
        this.num = num;
    }

    private void validate(int num) {

    }
}
