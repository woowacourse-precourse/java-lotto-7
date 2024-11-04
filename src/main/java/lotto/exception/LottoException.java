package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessage errorMessage){
        super("[ERROR] " + errorMessage.getMessage());
    }
}
