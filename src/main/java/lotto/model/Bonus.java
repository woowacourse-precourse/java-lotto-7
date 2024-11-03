package lotto.model;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
