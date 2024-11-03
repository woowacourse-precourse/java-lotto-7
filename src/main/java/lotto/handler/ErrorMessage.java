package lotto.handler;

public enum ErrorMessage {
    CASTING_ERROR("클래스 타입이 맞지 않거나 컨텐츠가 없습니다."),
    INVALID_PURCHASING_FORMAT_ERROR("구매 금액엔 숫자만 입력해주세요.\n"),
    INVALID_PURCHASING_RANGE_ERROR("1000원 이상 100000이하를 입력해주세요.\n"),
    INVALID_PURCHASING_UNIT_ERROR("1000원 단위가 아닙니다.\n");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
