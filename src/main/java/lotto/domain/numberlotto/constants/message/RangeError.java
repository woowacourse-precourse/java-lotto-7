package lotto.domain.numberlotto.constants.message;

import lotto.domain.numberlotto.constants.value.LottoRule;

public enum RangeError implements Message {
    NUMBER("[ERROR] 로또 번호는 "+ LottoRule.MINIMUM_NUMBER_RANGE.getValue() +"부터 "+ LottoRule.MAXIMUM_NUMBER_RANGE.getValue() +"사이여야 합니다."),
    LOTTO("[ERROR] 로또의 길이가 "+LottoRule.COMBINATION_LENGTH.getValue()+"과 일치하지 않습니다");

    private String message;

    RangeError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
