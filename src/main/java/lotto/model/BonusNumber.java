package lotto.model;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    private final int number;

    public BonusNumber(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(int number, Lotto lotto) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.");
        }
        if (lotto.isDuplicateWithLotto(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
