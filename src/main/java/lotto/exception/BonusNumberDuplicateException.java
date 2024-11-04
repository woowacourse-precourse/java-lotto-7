package lotto.exception;

public class BonusNumberDuplicateException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "보너스 번호는 로또 번호와 중복될 수 없습니다.";

    public BonusNumberDuplicateException() {
        super(DEFAULT_MESSAGE);
    }
}
