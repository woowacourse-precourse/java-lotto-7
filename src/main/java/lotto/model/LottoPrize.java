package lotto.model;

import lotto.constants.LottoConstants;

public enum LottoPrize {
    THREE_MATCHED(LottoConstants.THREE_MATCHED_PRIZE, LottoConstants.THREE_MATCHED_MESSAGE),
    FOUR_MATCHED(LottoConstants.FOUR_MATCHED_PRIZE, LottoConstants.FOUR_MATCHED_MESSAGE),
    FIVE_MATCHED(LottoConstants.FIVE_MATCHED_PRIZE, LottoConstants.FIVE_MATCHED_MESSAGE),
    BONUS_MATCHED(LottoConstants.BONUS_MATCHED_PRIZE, LottoConstants.BONUS_MATCHED_MESSAGE),
    SIX_MATCHED(LottoConstants.SIX_MATCHED_PRIZE, LottoConstants.SIX_MATCHED_MESSAGE);


    private final int prize;
    private final String message;

    LottoPrize(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage() {
        return String.format("%s (%,d원)", message, prize);
    }
}
