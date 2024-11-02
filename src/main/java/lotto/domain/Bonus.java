/*
 * 클래스 이름 Bonus
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.domain;

import lotto.constant.ErrorMessage;

public class Bonus {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    private final int bonus;

    public Bonus(String bonusNumber) {
        int bonus = parse(bonusNumber);
        validate(bonus);
        this.bonus = bonus;
    }

    private int parse(String bonusNumber) {
        int bonus;
        try {
            bonus = Integer.parseInt(bonusNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
        return bonus;
    }

    private void validate(int bonus) {
        validateRange(bonus);
    }

    private void validateRange(int bonus) {
        if (bonus < START_INCLUSIVE || bonus > END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE_ERROR_MESSAGE);
        }
    }
    public int getBonus() {
        return bonus;
    }
}
