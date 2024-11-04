package lotto.exception;

public enum ErrorMessages {

    CHECK_INT("입력값은 양수여야 합니다."),
    THOUSAND_UNIT("1000원 단위로 입력해야 합니다."),
    MIN_RANGE("최솟값은 1000입니다."),
    CHECK_SIZE("로또 번호는 6개여야 합니다."),
    CHECK_DUPLICATE("중복되는 숫자가 없어야 합니다."),
    CHECK_DUPLICATE_WITH_WINNING_NUMBER("당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE("숫자의 범위는 1부터 45입니다.");

    private final String startMessage = "[ERROR] ";
    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return startMessage+message;
    }

}
