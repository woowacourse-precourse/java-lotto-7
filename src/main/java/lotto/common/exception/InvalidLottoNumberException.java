package lotto.common.exception;

public class InvalidLottoNumberException extends LottoException{

    public InvalidLottoNumberException(int lottoNumber) {
        super(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage()+ "(로또 번호: " + lottoNumber + ")");
    }

    public InvalidLottoNumberException(int lottoNumber, Exception e) {
        super(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage() + "(로또 번호: " + lottoNumber + ")", e);
    }

    public InvalidLottoNumberException(String input) {
        super(ErrorMessage.LOTTO_NUMBER_MUST_BE_NUMBER.getMessage() + "(입력값: " + input + ")");
    }

    public InvalidLottoNumberException(String input, Exception e) {
        super(ErrorMessage.LOTTO_NUMBER_MUST_BE_NUMBER.getMessage() + "(입력값: " + input + ")", e);
    }
}

