package lotto.exception;

public enum LottoConfigurationExceptionMessage implements ExceptionMessage {
    MAX_NUMBER_LESS_THAN_MIN("MAX_LOTTO_NUMBER는 MIN_LOTTO_NUMBER보다 작을 수 없습니다."),
    NUMBER_COUNT_LESS_THAN_ONE("LOTTO_NUMBER_COUNT는 1보다 작을 수 없습니다."),
    PRICE_NOT_POSITIVE("LOTTO_TICKET_PRICE는 0이하의 값을 가질 수 없습니다.");

    private final String message;

    LottoConfigurationExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
