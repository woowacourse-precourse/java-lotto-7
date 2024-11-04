package lotto.util;

public enum LottoOperator {
    THREE_AGREEMENT(3, 5000, "개 일치 (5,000원) - ", 0),
    FOUR_AGREEMENT(4, 50000, "개 일치 (50,000원) - ", 0),
    FIVE_AGREEMENT(5, 1500000, "개 일치 (1,500,000원) - ", 0),
    FIVE_AND_BONUS_AGREEMENT(5, 30000000, "개 일치, 보너스 볼 일치 (30,000,000원) - ", 0),
    SIX_AGREEMENT(6, 2000000000, "개 일치 (2,000,000,000원) - ", 0);

    private static final int MIN_MATCHES_FOR_SECOND_OR_THIRD = 5;
    private static final int INCREMENT_STEP = 1;

    private int agree;
    private int amount;
    private String message;
    private int count;

    LottoOperator(int agree, int amount, String message, int count) {
        this.agree = agree;
        this.amount = amount;
        this.message = message;
        this.count = count;
    }

    private int getAgree() {
        return agree;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private void incrementCount() {
        this.count += LottoOperator.INCREMENT_STEP;
    }

    public static void addCount(boolean isMatchBonusNumber, long count) {
        for (LottoOperator lottoOperator : LottoOperator.values()) {
            if (lottoOperator.getAgree() == count && count == MIN_MATCHES_FOR_SECOND_OR_THIRD && isMatchBonusNumber) {
                FIVE_AND_BONUS_AGREEMENT.incrementCount();
                return;
            }
            if (lottoOperator.getAgree() == count && count == MIN_MATCHES_FOR_SECOND_OR_THIRD) {
                FIVE_AGREEMENT.incrementCount();
                return;
            }
            if (lottoOperator.getAgree() == count) {
                lottoOperator.incrementCount();
            }
        }
    }

    public String getResult() {
        return agree + message + count + "개";
    }

    public int getRateOfReturn() {
        return amount * count;
    }
}
