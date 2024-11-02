package lotto.util;

public enum ResultMessages {
    WINNING_STATICS("당첨 통계"),
    DIVIDER("---"),
    FIFTH_PRIZE("3개 일치 (5,000원) - %d개"),
    FOURTH_PRIZE("4개 일치 (50,000원) - %d개"),
    THIRD_PRIZE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");


    private final String message;

    ResultMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int amounts) {
        return String.format(message, amounts);
    }

    public String getMessage(float rate) {
        return String.format(message, rate);
    }
}
