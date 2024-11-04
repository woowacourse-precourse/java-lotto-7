package lotto.domain.model;

public class Profit {
    private static final String RATE_OF_RETURN_RULES = "%.1f";
    private static final String ERROR_AMOUNT_GRATER_THAN_ZERO = "[ERROR] 금액은 0보다 커야 합니다.";
    private static final String ERROR_REWARD_NOT_NEGATIVE = "[ERROR] 총 상금은 음수일 수 없습니다.";

    private final double rate;

    public Profit(int amount, int totalReward) {
        validate(amount, totalReward);
        this.rate = (totalReward / (double) amount) * 100.0;
    }

    private void validate(int amount, int totalReward) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_GRATER_THAN_ZERO);
        }

        if (totalReward < 0) {
            throw new IllegalArgumentException(ERROR_REWARD_NOT_NEGATIVE);
        }
    }

    @Override
    public String toString() {
        return String.format(RATE_OF_RETURN_RULES, rate);
    }
}
