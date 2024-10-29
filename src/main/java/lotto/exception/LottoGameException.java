package lotto.exception;

import lotto.config.LottoGameConfig;
import lotto.exception.custom.CustomException;

public class LottoGameException extends IllegalArgumentException {

    private final CustomException customException;

    public LottoGameException(CustomException customException) {
        this.customException = customException;
    }

    @Override
    public String getMessage() {
        return LottoGameConfig.ERROR_PREFIX + customException.getMessage();
    }

}
