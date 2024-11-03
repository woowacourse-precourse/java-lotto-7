package lotto.system.utils.constants;

public enum LottoErrorMessages implements MessageConstants {

    INVALID_MULTIPLE_OF_TICKET_PRICE("로또 구매 금액은 로또 한 장의 가격의 배수여야 합니다."),
    INSUFFICIENT_PAYMENT("로또 구매 금액은 로또 한 장의 가격보다 커야 합니다."),

    INVALID_NUMBER_RANGE("로또 번호는 %d부터 %d사이의 숫자여야 합니다."),
    INVALID_NUMBER_COUNT("로또 번호는 %d개여야 합니다."),
    INVALID_NUMBER_DUPLICATE("로또 번호는 중복되지 않아야 합니다.");



    private final String message;
    private final static String MESSAGE_FORMAT = "[ERROR] %s";

    LottoErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE_FORMAT, message);
    }
}
