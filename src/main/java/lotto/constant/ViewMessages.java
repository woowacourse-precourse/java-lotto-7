package lotto.constant;

public enum ViewMessages {
    PRINT_REQUEST_MONEY("구입금액을 입력해 주세요."),
    PRINT_REQUEST_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PRINT_REQUEST_LOTTO_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    PRINT_PURCHASED_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_PROFIT("총 수익률은 "),
    PRINT_REWARD_STATISTIC_FIRST("개 일치 ("),
    PRINT_REWARD_STATISTIC_SECOND("원) - "),
    PRINT_REWARD_STATISTIC_LAST("개"),
    PRINT_REWARD_SECOND_RANK_STATISTIC_FIRST("개 일치, 보너스 볼 일치 (");

    private final String message;

    private ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
