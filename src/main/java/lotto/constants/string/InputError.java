package lotto.constants.string;

import lotto.constants.Constants;
import lotto.constants.value.LottoRule;

public enum InputError implements Constants<String> {
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또의 번호 조합에 중복이 숫자가 발견되었습니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 숫자가 당첨 번호 안에 이미 존재합니다."),
    NONE_INTEGER_INPUT_PRICE("[ERROR] 구입 금액이 숫자가 아닙니다."),
    NOT_ENOUGH_INPUT_PRICE("[ERROR] 로또를 최소 한 개 구입해야합니다, "+ LottoRule.LOTTO_PRICE.getInstance() +"원 이상 투입해주세요.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    @Override
    public String getInstance() {
        return this.message;
    }
}
