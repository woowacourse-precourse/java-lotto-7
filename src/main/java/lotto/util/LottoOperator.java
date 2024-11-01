package lotto.util;

public enum LottoOperator {
    THREE_AGREEMENT(3, "개 일치(5,000원) - ", 0),
    FOUR_AGREEMENT(4, "개 일치(50,000원) - ", 0),
    FIVE_AGREEMENT(5, "개 일치(1,500,000원) - ", 0),
    FIVE_AND_BONUS_AGREEMENT(5, "개 일치, 보너스 볼 일치(30,000,000원) - ", 0),
    SIX_AGREEMENT(6, "개 일치(2,000,000,000원) - ", 0);

    private int agree;
    private String message;
    private int count;

    LottoOperator(int agree, String message, int count) {
        this.agree = agree;
        this.message = message;
        this.count = count;
    }

    public int getAgree() {
        return agree;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public static void addCount(boolean isMatchBonusNumber, long count) {
        for (LottoOperator lottoOperator : LottoOperator.values()) {
            if (lottoOperator.getAgree() == count && count == 5 && isMatchBonusNumber) {
                FIVE_AND_BONUS_AGREEMENT.setCount(1);
                return;
            }
            if (lottoOperator.getAgree() == count && count == 5) {
                FIVE_AGREEMENT.setCount(1);
                return;
            }

            if (lottoOperator.getAgree() == count) {
                lottoOperator.setCount(1);
            }
        }
    }

    public String getResult() {
        return agree + message + count + "개";
    }
}
