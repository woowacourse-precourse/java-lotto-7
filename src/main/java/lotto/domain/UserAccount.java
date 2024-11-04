package lotto.domain;

import lotto.global.ErrorMessage;

public class UserAccount {
    private final int inputMoney;
    private static final int LOTTO_PRICE = 1000;
    private static final float ROUNDING_FACTOR = 10.0f;
    private static final int PERCENTAGE_CONVERSION = 100;

    private UserAccount(int inputMoney) {
        this.inputMoney = inputMoney;
        validate(inputMoney);
    }

    public static UserAccount of(String rawInput) {
        return new UserAccount(Integer.parseInt(rawInput));
    }

    public int getTicketCount() {
        return inputMoney / LOTTO_PRICE;
    }

    private void validate(int inputMoney) {
        if (inputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public float calculateEarningRate(int totalReward) {
        float earningRate = (float) totalReward / inputMoney * PERCENTAGE_CONVERSION;
        return Math.round(earningRate * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
