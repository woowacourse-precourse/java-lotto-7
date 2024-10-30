package lotto.domain.errors;

import static lotto.domain.Lotto.LOTTO_COMBINATION_LENGTH;
import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public enum RangeError implements Errors {
    LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 "+MINIMUM_LOTTO_NUMBER+"부터 "+MAXIMUM_LOTTO_NUMBER+"사이여야 합니다."),
    LOTTO("[ERROR] 로또의 길이가 "+LOTTO_COMBINATION_LENGTH+"과 일치하지 않습니다");

    private String message;

    RangeError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
