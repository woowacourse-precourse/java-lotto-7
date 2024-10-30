package lotto.exception;

import lotto.enums.LottoErrorMessage;

public class LottoInputException extends IllegalArgumentException
{
    public LottoInputException(LottoErrorMessage errorMessage){
        super(errorMessage.getErrorMsg());
    }
}
