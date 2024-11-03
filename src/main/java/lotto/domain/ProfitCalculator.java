package lotto.domain;

import lotto.global.ErrorMessage;

public record ProfitCalculator(int inputMoney) {
    private static final int LOTTO_PRICE = 1000;

    public ProfitCalculator {
        validate(inputMoney);
    }

    public int getTicketCount(){
        return inputMoney / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public float calculateEarningRate(int totalReward) {
        float earningRate = (float) totalReward / inputMoney * 100;
        return Math.round(earningRate * 10) / 10.0f;
    }
}
