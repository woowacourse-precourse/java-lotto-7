package lotto.view;

import lotto.constants.PrizeTier;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PURCHASED("%d개를 구매했습니다."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_HEADER("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    THREE_MATCH("3개 일치 (%d원) - %d개\n", PrizeTier.FIFTH),
    FOUR_MATCH("4개 일치 (%d원) - %d개\n", PrizeTier.FOURTH),
    FIVE_MATCH("5개 일치 (%d원) - %d개\n", PrizeTier.THIRD),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", PrizeTier.SECOND),
    SIX_MATCH("6개 일치 (%d원) - %d개\n", PrizeTier.FIRST);

    private final String message;
    private final PrizeTier prizeTier;

    ViewMessage(String message) {
        this(message, null);
    }

    ViewMessage(String message, PrizeTier prizeTier) {
        this.message = message;
        this.prizeTier = prizeTier;
    }

    public String getMessage() {
        return message;
    }

    // 포맷팅할 때 prizeTier가 필요한 경우에만 호출
    public String formatMessage(int count) {
        return prizeTier != null
                ? String.format(message, prizeTier.getPrizeAmount(), count)
                : String.format(message, count);
    }

    public String formatProfitRate(double rate) {
        return String.format(PROFIT_RATE.message, rate);
    }
}
