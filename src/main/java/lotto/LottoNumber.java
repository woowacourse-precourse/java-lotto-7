package lotto;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        if (inRange(number)) {
            throw new IllegalArgumentException("로또의 숫자는 1~45사이의 숫자이여야 합니다.");
        }
    }

    private static boolean inRange(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }
}
