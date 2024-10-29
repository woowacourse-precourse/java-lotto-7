package lotto.view;

import static lotto.constants.PrizeMoney.FIFTH_PRIZE;
import static lotto.constants.PrizeMoney.FIRST_PRIZE;
import static lotto.constants.PrizeMoney.FOURTH_PRIZE;
import static lotto.constants.PrizeMoney.SECOND_PRIZE;
import static lotto.constants.PrizeMoney.THIRD_PRIZE;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PURCHASED("%d개를 구매했습니다."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_HEADER("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    THREE_MATCH("3개 일치 (%d원) - %d개\n", FIFTH_PRIZE),
    FOUR_MATCH("4개 일치 (%d원) - %d개\n", FOURTH_PRIZE),
    FIVE_MATCH("5개 일치 (%d원) - %d개\n", THIRD_PRIZE),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", SECOND_PRIZE),
    SIX_MATCH("6개 일치 (%d원) - %d개\n", FIRST_PRIZE);
    private final String message;
    private final Integer prizeMoney;

    ViewMessage(String message) {
        this(message, null);
    }

    ViewMessage(String message, Integer prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    // 포맷팅할 때 prizeMoney가 필요한 경우에만 호출
    public String formatMessage(int count) {
        return prizeMoney != null ? String.format(message, prizeMoney, count) : String.format(message, count);
    }

}
