package lotto.exception;

public class InvalidLottoNumberRangeException extends LottoException{

    private static final String MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다. ";

    public InvalidLottoNumberRangeException(int lottoNumber) {
        super(MESSAGE + "(로또 번호: " + lottoNumber + ")");
    }

    public InvalidLottoNumberRangeException(int lottoNumber, Exception e) {
        super(MESSAGE + "(로또 번호: " + lottoNumber + ")", e);
    }
}
