package lotto.domain.errorMessage;

public enum ErrorMessage {
    EMPTY_MESSAGE("입력값이 비어있습니다."),
    UNKNOWN_ERROR("예상하지 못한 에러가 발생했습니다."),
    NO_AVAILABLE_MACHIN("지금은 사용가능한 로또머신이 없습니다.")
    ;

    private final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
