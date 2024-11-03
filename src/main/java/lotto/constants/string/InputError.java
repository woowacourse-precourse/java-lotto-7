package lotto.constants.string;

import lotto.constants.Constants;
import lotto.constants.value.LottoRule;

public enum InputError implements Constants<String> {

    //로또 구입 가격과 관련된 오류
    BLANK_INPUT_PRICE("[ERROR] 구입하고자 하는 가격에 공백이 입력되었습니다."),
    NONE_INTEGER_INPUT_PRICE("[ERROR] 구입 금액이 숫자가 아닙니다."),
    NOT_ENOUGH_INPUT_PRICE("[ERROR] 로또를 최소 한 개 구입해야합니다, " + LottoRule.LOTTO_PRICE.getInstance() + "원 이상 투입해주세요."),
    NOT_DIVIDABLE_BY_LOTTO_PRICE("[ERROR] 구입 금액이 " + LottoRule.LOTTO_PRICE.getInstance() + "으로 나누어지지 않습니다."),

    //로또 당첨 번호와 관련된 오류
    BLANK_WINNING_NUMBER("[ERROR] 로또 당첨 번호로 공백을 입력할 수 없습니다"),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또의 번호 조합에 중복이 숫자가 발견되었습니다."),
    NOT_ALLOWED_NONE_INTEGER("[ERROR] 구분자 " + Delimiter.DEFAULT.getInstance() + " 이외의 숫자가 아닌 값이 있습니다."),
    CANNOT_START_OR_END_WITH_DELIMETER("[ERROR] 구분자로 시작하거나 끝날 수 없습니다."),

    //보너스 번호와 관련된 오류
    BLANK_BONUS_NUMBER("[ERROR] 보너스 번호로 공백을 입력할 수 없습니다."),
    NONE_INTEGER_BONUS_NUMBER("[ERROR] 보너스 숫자로 숫자가 입력되지 않았습니다"),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 숫자가 당첨 번호 안에 이미 존재합니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    @Override
    public String getInstance() {
        return this.message;
    }
}
