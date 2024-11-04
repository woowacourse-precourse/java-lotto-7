package lotto.model;

import static lotto.util.Constant.MAX_LOTTO_NUM;
import static lotto.util.Constant.ZERO;

public class BonusNumber {

    private final int bonusNumber;

    private static final String ONLY_NUMBER = "숫자만 입력해 주세요!";
    private static final String NEGATIVE_NUMBER = "양수를 입력해주세요!";
    private static final String WRONG_RANGE = "숫자 범위가 벗어났습니다.";

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = validateNumber(bonusNumber);
    }

    private int validateNumber(String bonusNumber) {
        int uncheckedMoney = checkNumber(bonusNumber);
        checkPositiveNumber(uncheckedMoney);
        checkRange(uncheckedMoney);

        return uncheckedMoney;
    }

    private int checkNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private void checkPositiveNumber(int bonusNumber) {
        if (!(ZERO < bonusNumber)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }

    private void checkRange(int bonusNumber) {
        if (!(bonusNumber > ZERO && bonusNumber <= MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException(WRONG_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
