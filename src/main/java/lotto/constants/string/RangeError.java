package lotto.constants.string;

import lotto.constants.Constants;
import lotto.constants.value.LottoRule;

public enum RangeError implements Constants<String> {

    NUMBER("[ERROR] 로또 번호는 " + LottoRule.MINIMUM_NUMBER_RANGE.getInstance() + "부터 " + LottoRule.MAXIMUM_NUMBER_RANGE.getInstance() + "사이여야 합니다."),
    LOTTO_LENGTH("[ERROR] 로또의 길이가 " + LottoRule.COMBINATION_LENGTH.getInstance() + "과 일치하지 않습니다");

    private final String message;

    RangeError(String message) {
        this.message = message;
    }

    @Override
    public String getInstance() {
        return message;
    }
}
