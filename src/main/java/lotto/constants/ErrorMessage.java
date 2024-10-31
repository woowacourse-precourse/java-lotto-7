package lotto.constants;

public enum ErrorMessage {

    INTEGER_TYPE("양의 정수여야 합니다."),
    NUMBER_RANGE(String.format("%d부터 %d 사이의 숫자여야 합니다."
            ,LottoConstants.LOTTO_START_INCLUSIVE
            ,LottoConstants.LOTTO_END_INCLUSIVE)),

    PURCHASE_TYPE("구입 금액은 " + INTEGER_TYPE),
    PURCHASE_UNIT("구입 금액은 1000원 단위여야 합니다."),

    BONUS_NUMBER_TYPE("보너스 번호는 " + INTEGER_TYPE),
    BONUS_NUMBER_RANGE("보너스 번호는 " + NUMBER_RANGE),

    INPUT_PATTERN("로또 번호는 정수와 쉼표(,)로 이루어져야 합니다."),

    NUMBER_SIZE(String.format("로또 번호는 %d개여야 합니다.", LottoConstants.NUMBER_COUNT)),
    NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 " + NUMBER_RANGE);

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
