package lotto.domain;

import java.text.DecimalFormat;

import lotto.constant.OutputMessage;

public enum LottoResult {
    NO_MATCH("불일치", 0),
    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000);

    public final String info;
    public final int price;

    LottoResult(String info, int price) {
        this.info = info;
        this.price = price;
    }

    public static LottoResult getLottoResult(int count, boolean isBonusMatched) {
        if (count == 6) {
            return SIX_MATCH;
        }

        if (count == 5 && isBonusMatched) {
            return FIVE_MATCH_BONUS;
        }

        if (count == 5) {
            return FIVE_MATCH;
        }

        if (count == 4) {
            return FOUR_MATCH;
        }

        if (count == 3) {
            return THREE_MATCH;
        }

        return NO_MATCH;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(OutputMessage.PRICE_DECIMAL_FORMAT);
        return OutputMessage.LOTTO_RESULT_TYPE_FORMAT.formatted(info, formatter.format(price));
    }
}
