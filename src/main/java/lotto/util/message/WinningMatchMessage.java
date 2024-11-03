package lotto.util.message;

import lotto.rule.Prize;

public enum WinningMatchMessage implements Message {

    FIFTH("3개 일치 (%s원)"),
    FOURTH("4개 일치 (%s원)"),
    THIRD("5개 일치 (%s원)"),
    SECOND("5개 일치, 보너스 볼 일치 (%s원)"),
    FIRST("6개 일치 (%s원)"),
    ;

    private final String message;

    WinningMatchMessage(String message) {
        this.message = message;
    }

    @Override
    public String get() {
        return String.format(message, formatPrizeAmount());
    }

    private String formatPrizeAmount() {
        String currencyFormatPattern = "%,d";
        if (this.equals(FIRST)) {
            return String.format(currencyFormatPattern, Prize.FIRST.getPrizeAmount());
        }
        if (this.equals(SECOND)) {
            return String.format(currencyFormatPattern, Prize.SECOND.getPrizeAmount());
        }
        if (this.equals(THIRD)) {
            return String.format(currencyFormatPattern, Prize.THIRD.getPrizeAmount());
        }
        if (this.equals(FOURTH)) {
            return String.format(currencyFormatPattern, Prize.FOURTH.getPrizeAmount());
        }
        if (this.equals(FIFTH)) {
            return String.format(currencyFormatPattern, Prize.FIFTH.getPrizeAmount());
        }
        throw new IllegalStateException(LottoErrorMessage.NOT_ALLOWED_PRIZE_TYPE.get());
    }
}
