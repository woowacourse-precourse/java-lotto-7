package lotto.common.exception;

public class InvalidLottoNumberRangeException extends LottoException{

    public InvalidLottoNumberRangeException(int lottoNumber) {
        super(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage()+ "(로또 번호: " + lottoNumber + ")");
    }

    public InvalidLottoNumberRangeException(int lottoNumber, Exception e) {
        super(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage() + "(로또 번호: " + lottoNumber + ")", e);
    }
}
