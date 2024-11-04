package lotto.error;

public enum ErrorMessage {

    AMOUNT_FORMAT_ERROR("금액은 정수 형태로 입력해야 합니다."),
    NUMBER_FORMAT_ERROR("잘못된 로또 번호입니다."),
    NUMBER_RANGE_ERROR("%d 이상 %d 이하의 숫자여야 합니다."),
    NUMBER_COUNT_ERROR("번호는 %d개 입니다."),
    INVALID_AMOUNT_UNIT("구매 금액은 %d원 단위로 입력해야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨번호와 중복되지 않아야 합니다."),
    DUPLICATED_NUMBER_ERROR("중복된 번호가 없어야 합니다."),
    EMPTY_STRING_ERROR("빈 문자열입니다.");

    private final String content;

    ErrorMessage(String content){
        this.content =content;
    }

    public String format(Object... args) {
        return String.format(content, args);
    }
}
