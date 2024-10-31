package lotto.exception;

public class NotNumberOrCommaException extends IllegalArgumentException {
    public NotNumberOrCommaException() {
        super("숫자 또는 콤마(,)만 입력 가능합니다. 콤마로 숫자 6개를 구분하여 입력해주세요.");
    }
}
