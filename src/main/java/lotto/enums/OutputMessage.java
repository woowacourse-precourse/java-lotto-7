package lotto.enums;

import java.text.DecimalFormat;

public enum OutputMessage implements MessageProvider {
    PURCHASED_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    LOTTO_WINNING_MESSAGE("당첨 통계\n---"),
    EARNING_RATE_RESULT_MESSAGE("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getLottoCountMessage(int count) {
        return String.format(message, count);
    }

    public String getEarningRateResultMessage(double earningRateResult) {
        String formatEarningRate = getKoreaFormatTotalEarning(earningRateResult);
        return String.format(message, formatEarningRate);
    }

    public String getKoreaFormatTotalEarning(double totalEarning) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        return decimalFormat.format(totalEarning);
    }
}