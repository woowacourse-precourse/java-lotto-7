package lotto.view;

public enum LottoMessageFormats {
    LINE_BREAK("\n"),
    INPUT_PURCHASE_AMOUNT_PROMPT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_PROMPT_MESSAGE(LINE_BREAK.message + "당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_PROMPT_MESSAGE(LINE_BREAK.message + "보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASED_COUNT_MESSAGE(LINE_BREAK.message + "%d개를 구매했습니다." + LINE_BREAK.message),
    OUTPUT_WINNING_STATISTICS_HEADER(LINE_BREAK.message + "당첨 통계" + LINE_BREAK.message + "---"),
    OUTPUT_BONUS_RESULT_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + LINE_BREAK.message),
    OUTPUT_MATCH_RESULT_FORMAT("%d개 일치 (%s원) - %d개" + LINE_BREAK.message),
    OUTPUT_RETURN_RATE_MESSAGE_FORMAT("총 수익률은 %.1f%%입니다." + LINE_BREAK.message),
    OUTPUT_PRIZE_FORMAT("#,###");

    private final String message;

    LottoMessageFormats(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}