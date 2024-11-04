package lotto.view;

public enum PrintMessage {
    INPUT_TOTAL_COST("구입금액을 입력해 주세요. "),
    TICKET_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요. "),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요. "),
    WINNING_STAT_ANNOUNCEMENT("당첨 통계 \n---"),
    MATCH_THREE("3개 일치 (5,000원) - "),
    MATCH_FOUR("4개 일치 (50,000원) - "),
    MATCH_FIVE("5개 일치 (1,500,000원) - "),
    MATCH_FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_SIX("6개 일치 (2,000,000,000원) - "),
    MATCH_END("개"),
    RATE_OF_RETURN_PART_START("총 수익률은 "),
    RATE_OF_RETURN_PART_END("%입니다.");
    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
