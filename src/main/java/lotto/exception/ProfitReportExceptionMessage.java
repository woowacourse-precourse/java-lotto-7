package lotto.exception;

public enum ProfitReportExceptionMessage implements ExceptionMessage {
    NULL_OR_EMPTY_LOTTOS("구매한 로또는 null 또는 비어있을 수 없습니다."),
    NULL_WINNING_NUMBERS("당첨 번호는 null일 수 없습니다.")
    ;

    private final String message;

    ProfitReportExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
