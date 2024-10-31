package lotto.constants;

public enum ErrorMessage {

    PURCHASE_TYPE("구입 금액은 양의 정수여야 합니다."),
    PURCHASE_UNIT("구입 금액은 1000원 단위여야 합니다."),

    INPUT_PATTERN("로또 번호는 정수와 쉼표(,)로 이루어져야 합니다."),

    NUMBER_SIZE(String.format("로또 번호는 %d개여야 합니다.", LottoConstants.NUMBER_COUNT)),
    NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    NUMBER_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
            , LottoConstants.LOTTO_START_INCLUSIVE
            , LottoConstants.LOTTO_END_INCLUSIVE)),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
