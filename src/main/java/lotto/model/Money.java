package lotto.model;

public record Money (int amount) {

    public Money {
        validate(amount);
    }

    public int getLottoTicket() {
        return amount / 1000;
    }

    public PrizeRate calculatePrizeRate(Result result) {
        long prize = result.calculatePrize();
        return new PrizeRate((double) prize / amount * 100);
    }

    private void validate(int input) {
        validateIsDivisible(input);
        validateBelowMinimum(input);
    }

    private void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 원 단위의 값이어야 합니다.");
        }
    }

    private void validateBelowMinimum(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000 원 이상의 값이어야 합니다.");
        }
    }
}
