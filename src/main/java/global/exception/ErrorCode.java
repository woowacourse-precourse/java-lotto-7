package global.exception;

import static global.constant.GlobalStatic.LOTTO_END_NUMBER;
import static global.constant.GlobalStatic.LOTTO_NUMBER_COUNTS;
import static global.constant.GlobalStatic.LOTTO_START_NUMBER;
import static global.constant.GlobalStatic.PURCHASE_AMOUNT_UNIT;
import static global.constant.GlobalStatic.WEEKLY_NUMBER_COUNTS;

public enum ErrorCode {

    LOTTO_NUMBER_COUNT_MISMATCH("로또 번호는 %d개 여야 합니다.".formatted(LOTTO_NUMBER_COUNTS)),
    LOTTO_NUMBER_CANNOT_BE_DUPLICATE("중복된 값은 불가합니다."),
    LOTTO_NUMBER_RANGE_MISMATCH("%d와 %d 사이의 값이 입력되어야 합니다.".formatted(LOTTO_START_NUMBER, LOTTO_END_NUMBER)),
    PURCHASE_AMOUNT_UNIT_MISMATCH("%d원 단위의 입력만 가능합니다.".formatted(PURCHASE_AMOUNT_UNIT)),
    WEEKLY_NUMBERS_COUNT_MISMATCH("당첨 번호는 %d개 여야 합니다.".formatted(WEEKLY_NUMBER_COUNTS)),
    BONUS_NUMBER_CANNOT_BE_DUPLICATE("이미 당첨 번호로 설정된 중복 숫자입니다."),
    INPUT_CANNOT_INCLUDE_BLANK("공백이 포함된 입력은 불가합니다."),
    INPUT_CANNOT_START_WITH_ZERO("0으로 시작하는 값은 입력할 수 없습니다."),
    INPUT_CANNOT_INCLUDE_PLUS_SIGN("+ 기호가 포함된 입력은 불가합니다."),
    INPUT_CANNOT_BE_DECIMAL("소수의 입력은 불가합니다."),
    INPUT_MUST_BE_POSITIVE("0 이하의 값은 입력할 수 없습니다."),
    INPUT_SHOULD_BE_PARSING("숫자로 변환할 수 있는 값이어야 합니다.");

    private String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}