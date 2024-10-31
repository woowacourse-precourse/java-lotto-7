package lotto.error;

import static lotto.constant.LottoRule.MAX_NUMBER;
import static lotto.constant.LottoRule.MIN_NUMBER;
import static lotto.constant.LottoRule.MONEY_UNIT;
import static lotto.constant.LottoRule.WINNING_NUMBER_SIZE;

public class ErrorType {
    
    public static final String EXCEEDED_NUMBER_RANGE = String.format("번호는 %d부터 %d 사이의 자연수여야 합니다.", MIN_NUMBER, MAX_NUMBER);
    public static final String INVALID_WINNING_NUMBER_SIZE = String.format("당첨 번호는 %d자리여야 합니다.", WINNING_NUMBER_SIZE);
    public static final String INVALID_NUMBER_FORMAT = "숫자는 자연수만 가능합니다.";
    public static final String INVALID_MONEY_FORMAT = String.format("구입 금액은 %,d원 단위로만 가능합니다.", MONEY_UNIT);
    public static final String DUPLICATED_WINNING_NUMBERS = "당첨 번호은 서로 중복될 수 없습니다.";
    public static final String DUPLICATED_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private ErrorType() {
    }
}
