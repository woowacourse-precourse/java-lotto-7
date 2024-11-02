package lotto.exception;

public class InvalidLottoSizeException extends LottoException{

    public InvalidLottoSizeException(int lottoSize) {
        super(ErrorMessage.LOTTO_SIZE_OUT_OF_RANGE.getMessage() + "(로또 번호 개수: " + lottoSize + ")");
    }

    public InvalidLottoSizeException(int lottoSize, Exception e) {
        super(ErrorMessage.LOTTO_SIZE_OUT_OF_RANGE.getMessage() + "(로또 번호 개수: " + lottoSize + ")", e);
    }
}
