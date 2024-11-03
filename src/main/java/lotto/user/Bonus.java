package lotto.user;

import lotto.system.unit.LottoNumber;

public class Bonus { // 사용자 입력 보너스 검증 후 객체 생성

    private final int number;

    public Bonus(int number) {
        validateBound(number);
        this.number = number;
    }

    private void validateBound(int number) {
        if (number < LottoNumber.LOTTO_NUMBER_LOWER_BOUND || number > LottoNumber.LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(String.format("[ERROR] 보너스 번호는 %d부터 %d사이의 숫자여야 합니다.",
                    LottoNumber.LOTTO_NUMBER_LOWER_BOUND, LottoNumber.LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    public int getNumber() {
        return number;
    }
}
