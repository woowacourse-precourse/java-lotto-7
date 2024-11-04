package lotto.handler;

public enum ErrorMessage {
    CASTING_ERROR("클래스 타입이 맞지 않거나 컨텐츠가 없습니다."),
    INVALID_PURCHASING_FORMAT_ERROR("구매 금액엔 숫자만 입력해주세요.\n"),
    INVALID_PURCHASING_RANGE_ERROR("1000원 이상 100000이하를 입력해주세요.\n"),
    INVALID_PURCHASING_UNIT_ERROR("1000원 단위가 아닙니다.\n"),
    DUPLICATED_WINNING_NUMBER_ERROR("당첨 번호 리스트에 중복된 숫자가 있습니다.\n"),
    DUPLICATED_BONUS_NUMBER_ERROR("보너스 번호가 당첨 번호와 중복됩니다.\n"),
    INVALID_BONUS_NUMBER_FORMAT_ERROR("보너스 번호에는 1~45의 숫자 하나만 들어갈 수 있습니다.\n"),
    INVALID_BONUS_NUMBER_RANGE_ERROR("보너스 번호는 1이상 45이하입니다.\n"),
    INVALID_WINNING_NUMBER_COUNT_ERROR("총 6개의 당첨 숫자를 입력해야합니다.\n"),
    INVALID_WINNING_NUMBER_FORMAT_ERROR("당첨 숫자는 숫자와 \",\"가 번갈아가며 6개, 5개 포함되어야 합니다. ex)1,2,3,4,5,6\n"),
    INVALID_WINNING_NUMBER_RANGE_ERROR("당첨 숫자 번호는 1이상 45 이하입니다.\n");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
