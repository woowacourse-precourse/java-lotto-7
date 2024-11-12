package lotto.Message;

public enum ErrorMessage {
    ERROR_INVALID_NUMBER("[ERROR] 숫자가 아닙니다."),
    ERROR_NOT_THOUSAND_UNIT("[ERROR] 1,000원 단위로 입력해야 합니다."),
    ERROR_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_DUPLICATES("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ERROR_BONUS_IN_WINNING("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");


    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}