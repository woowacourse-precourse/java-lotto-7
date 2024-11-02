package lotto.model;

public record Money (int amount) {

    public Money {
        validate(amount);
    }

    private void validate(int input) {
        validateIsDivisible(input);
    }

    private void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("1,000 원 단위의 값이어야 합니다.");
        }
    }
}
