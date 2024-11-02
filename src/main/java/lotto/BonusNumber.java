package lotto;

import java.util.List;

public class BonusNumber {
    private static final int COUNTS_OF_BONUS = 1;
    private static final int MAX_VALUE_OF_LOTTO = 45;
    private static final int MIN_VALUE_OF_LOTTO = 1;

    private final int number;

    public BonusNumber(List<String> number) throws IllegalArgumentException {
        validate(number);
        this.number = Integer.parseInt(number.get(0));
    }

    private void validate(List<String> number) {
        isSizeOne(number);
        String bonusNumber = number.get(0);
        isNotNumber(bonusNumber);
        isOutOfBound(bonusNumber);
    }

    private void isSizeOne(List<String> number) {
        if (number.size() != COUNTS_OF_BONUS) {
            throw new IllegalArgumentException("[ERROR] 1개의 보너스 번호를 입력해 주세요.");
        }
    }

    private void isNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력이 존재합니다.");
        }
    }

    private void isOutOfBound(String number) {
        int bonusNumber = Integer.parseInt(number);
        if (bonusNumber < MIN_VALUE_OF_LOTTO || bonusNumber > MAX_VALUE_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 수를 입력해 주세요.");
        }
    }

    public int number() {
        return number;
    }
}
