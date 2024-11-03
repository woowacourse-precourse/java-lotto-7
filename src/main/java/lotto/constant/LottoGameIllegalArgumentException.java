package lotto.constant;

public class LottoGameIllegalArgumentException extends IllegalArgumentException {
    public LottoGameIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        System.out.println(errorMessage.getMessage());
    }
}
