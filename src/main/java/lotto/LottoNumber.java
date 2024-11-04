package lotto;

public class LottoNumber {
    protected static final int NUMBERS_SIZE = 6;
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;

    protected static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이입니다.");
        }
    }
}
