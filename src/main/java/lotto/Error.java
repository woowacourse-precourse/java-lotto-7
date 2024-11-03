package lotto;

import static lotto.LottoGenerator.*;
import static lotto.Util.cashFormat;

public enum Error {

    BONUS_NUMBER_INVALID_RANGE("보너스 번호는 " + MIN_NUMBER + "이상 " + MAX_NUMBER + " 이하의 숫자입니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨번호 "+ NUMBER_COUNT +"개와 중복될 수 없습니다."),
    LOTTO_NUMBER_COUNT("로또 번호는 " + NUMBER_COUNT + "개여야 합니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 " + MIN_NUMBER + "이상 " + MAX_NUMBER + " 이하의 숫자입니다."),
    LOTTO_NUMBER_DUPLICATED("번호들은 서로 중복되지 않아야 합니다."),
    AMOUNT_RANGE_ERROR("구입금액은 최소 " + cashFormat(PRICE) + "원부터 최대 " + cashFormat(LIMIT_PRICE) + "원 입니다."),
    AMOUNT_UNIT_ERROR("구입금액은 " + cashFormat(PRICE) + "원 단위로 입력하세요."),
    INPUT_FORMAT_ERROR(NUMBER_COUNT + "개의 당첨번호를 쉼표(,)로 구분하여 입력해주세요."),
    NOT_NUMBER("숫자만 입력하세요."),
    ;

    private final String errorMessage;
    private static final String ERROR_INTRO = "[ERROR] ";

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return ERROR_INTRO + errorMessage;
    }
}
