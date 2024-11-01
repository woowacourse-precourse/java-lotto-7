package lotto.util.enums;

public enum ValidateMessage {
    INPUT_ERROR("소수점이 없는 양수, 쉼표(,)로만 입력해주세요."),

    NUMBER_SIZE_ERROR("당첨번호의 개수가 6개가 아닙니다."),
    NUMBER_RANGE_ERROR("1 ~ 45 사이의 숫자만 입력해주세요."),
    DUPLICATE_ERROR("서로 다른 숫자를 입력해주세요.")
    ;

    private final String message;

    ValidateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        //Enum class 에서는 static final 쓸 수 없나?
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
