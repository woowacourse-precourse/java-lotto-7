package lotto.domain;

public class Bonus {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private final int number;

    public Bonus(int number) {
        checkIfNumberRangeIsValid(number);
        this.number = number;
    }

    public boolean isSame(int number) {
        return this.number == number;
    }

    private void checkIfNumberRangeIsValid(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
