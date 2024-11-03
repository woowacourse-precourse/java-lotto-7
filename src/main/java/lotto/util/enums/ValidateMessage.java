package lotto.util.enums;

public enum ValidateMessage {
    INPUT_ERROR("소수점이 없는 양수만 입력해주세요.(여려개의 숫자는 쉼표(,)로 구분)"),

    NUMBER_SIZE_ERROR("당첨번호의 개수가 6개가 아닙니다."),
    NUMBER_RANGE_ERROR("1 ~ 45 사이의 숫자만 입력해주세요."),
    DUPLICATE_ERROR("서로 다른 숫자를 입력해주세요."),

    SAME_WITH_LOTTO_NUMBER_ERROR("당첨 번호와 다른 번호를 입력해주세요."),

    NOT_ONE_THOUSAND_MULTIPLE_ERROR("금액이 1000원으로 떨어지지 않습니다. 금액을 다시 입력해주세요"),
    NOT_PURCHASE_MORE_HUNDRED_THOUSAND("총 구매는 10만원 이하로 가능합니다. 금액을 다시 입력해주세요")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ValidateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
