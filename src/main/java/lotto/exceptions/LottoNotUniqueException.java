package lotto.exceptions;

public class LottoNotUniqueException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야합니다.";
    public LottoNotUniqueException() {
        super(MESSAGE);
    }
}
