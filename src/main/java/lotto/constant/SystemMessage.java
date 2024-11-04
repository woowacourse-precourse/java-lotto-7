package lotto.constant;

public enum SystemMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    DISPLAY_PURCHASED_LOTTO_COUNT("%d개를 구매했습니다."),

    RESULT_HEADER("당첨통계\n---"),
    MATCH_SIX("6개 일치 (2,000,000,000원) - %d개"),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_FIVE("5개 일치 (1,500,000원) - %d개"),
    MATCH_FOUR("4개 일치 (50,000원) - %d개"),
    MATCH_THREE("3개 일치 (5,000원) - %d개"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    //생성자
    SystemMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
