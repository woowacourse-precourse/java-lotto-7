package lotto.domain;

public record Bonus(int number) {
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;

    public Bonus {
        validate(number);
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
        }
    }
}
