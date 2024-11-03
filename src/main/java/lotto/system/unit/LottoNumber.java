package lotto.system.unit;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumber implements Comparable<LottoNumber> { // 사용자가 입력 로또 번호 하나를 의미하는 객체

    public final static int LOTTO_NUMBER_LOWER_BOUND = 1;
    public final static int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final static String ERROR_MESSAGE = "[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.";

    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        validate(number);
        return new LottoNumber(number);
    }

    public static void validate(final int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, LOTTO_NUMBER_LOWER_BOUND,
                    LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND);
    }

    public int getValue() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
