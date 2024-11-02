package lotto.constant;

import java.text.DecimalFormat;

public enum ExceptionMessage {
    /* IllegalArgumentException */
    INVALID_LOTTO_NUMBER_COUNT(
        String.format("로또 번호는 %d개여야 합니다.",
            LottoConfig.DEFAULT_NUMBER_COUNT)),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    NOT_NUMBER_MONEY("구입금액은 숫자여야 합니다."),
    NOT_NUMBER_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    INVALID_MONEY_UNIT("로또 구입 금액은 %s원 단위로 입력해야 합니다."),
    BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER(
        String.format("로또 번호는 %d에서 %d 이내의 숫자여야 합니다.",
            LottoConfig.LOTTO_NUMBER_START_INCLUSIVE,
            LottoConfig.LOTTO_NUMBER_END_INCLUSIVE)),

    /* IllegalStateException */
    NOT_EXIST_RANK("존재하지 않는 등수입니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message);
    }

    public String getMessage(int content) {
        if (equals(INVALID_MONEY_UNIT)) {
            return String.format(message, new DecimalFormat("###,###").format(content));
        }
        return String.format(message, content);
    }
}
