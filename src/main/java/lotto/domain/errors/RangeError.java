package lotto.domain.errors;

import static lotto.domain.lotto.Lotto.LOTTO_COMBINATION_LENGTH;
import static lotto.domain.lotto.Number.MAXIMUM_NUMBER_RANGE;
import static lotto.domain.lotto.Number.MINIMUM_NUMBER_RANGE;

public enum RangeError implements Errors {
    NUMBER("[ERROR] 로또 번호는 "+ MINIMUM_NUMBER_RANGE +"부터 "+ MAXIMUM_NUMBER_RANGE +"사이여야 합니다."),
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
