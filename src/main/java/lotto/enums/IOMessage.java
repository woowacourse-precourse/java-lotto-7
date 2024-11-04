package lotto.enums;

public enum IOMessage implements SystemMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    PRINT_QUANTITY_OF_LOTTOS("개를 구매했습니다."),
    PRINT_WINNING_STATISTIC("당첨 통계"),
    PRINT_WINNING_STATISTIC_SEPARATER("---"),
    PRINT_UNIT_OF_QUANTITY("개"),
    PRINT_THREE_MATCHING_QUANTITY("3개 일치 (5,000원) - "),
    PRINT_FOUR_MATCHING_QUANTITY("4개 일치 (50,000원) - "),
    PRINT_FIVE_MATCHING_QUANTITY("5개 일치 (1,500,000원) - "),
    PRINT_FIVE_MATCHING_QUANTITY_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_SIX_MATCHING_QUANTITY("6개 일치 (2,000,000,000원) - "),
    PRINT_TOTAL_RETURN_RATE("총 수익률은 %.1f%%입니다."),
    PRINT_NO_MONEY_EARNED("아쉽게도 수익이 발생하지 않았습니다. 다음 기회를 노려보세요!");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
