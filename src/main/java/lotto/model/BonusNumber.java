package lotto.model;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    private final int number;

    public BonusNumber(int num, Lotto lotto) {
        validate(num, lotto);
        number = num;
    }

    private void validate(int num, Lotto lotto) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.");
        }

        if (lotto.isDuplicateWithLotto(num)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
