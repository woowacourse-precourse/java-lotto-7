package lotto.domain;

public class Bonus {
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;

    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
