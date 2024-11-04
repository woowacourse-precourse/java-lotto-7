package lotto.model;

public enum ExceptionMessage {
    EMPTY_VALUE("빈 입력값입니다."),
    INVALID_PRICE("구입금액은 0보다 큰 1000의 배수인 정수여야 합니다."),
    INVALID_NUMBER_LIST("당첨 번호는 1이상 45이하의 정수, 쉼표(,)로 구성된 문자열이여야 합니다."),
    INVALID_RANGE_NUMBER("로또 번호는 1이상 45이하의 정수여야 합니다."),
    INVALID_DUPLICATE_NUMBER("로또 번호는 중복된 값이 존재할 수 없습니다."),
    INVALID_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_TYPE("입력값은 정수여야 합니다"),
    BONUS_NUMBER_CONTAINED("보너스 볼은 당첨 번호와 다른 값이어야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
