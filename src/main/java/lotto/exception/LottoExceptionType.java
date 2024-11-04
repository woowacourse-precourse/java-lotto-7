package lotto.exception;

public enum LottoExceptionType implements BaseExceptionType {
    NOT_MATCH_LOTTONUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTONUMBER("[ERROR] 로또 번호가 중복됩니다."),
    OUT_OF_RANGE_LOTTONUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    private final String errorMessage;

    LottoExceptionType(String errorMessage){
        this.errorMessage = errorMessage;
    }
    @Override
    public String errorMessage() {
        return errorMessage;
    }
}