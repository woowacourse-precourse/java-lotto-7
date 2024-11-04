package lotto.view;

import static lotto.view.ViewConstants.HYPHEN;
import static lotto.view.ViewConstants.VIEW_DELIMITER_LABEL;

public class ViewMessageContainer {
    public static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String ENTER_WINNING_LOTTO_NUMBERS
            = String.format("당첨 번호를 입력해 주세요.(번호는 %s 기준으로 구분)", VIEW_DELIMITER_LABEL);
    public static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String NOTICE_ISSUED_LOTTO_QUANTITY = "%s개를 구매했습니다.";
    public static final String WINNING_STATISTICS = String.join(System.lineSeparator(), "당첨 통계", HYPHEN.repeat(3));
    public static final String WINNING_DETAILS_TEMPLATE = "%d개 일치 (%,d원) - %d개";
    public static final String SECOND_WINNING_DETAILS_TEMPLATE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";

    public static final String ERROR_MESSAGE = "[ERROR]";

    public static final String NON_DIGIT_ERROR
            = String.format("%s 숫자만 입력해야 합니다.", ERROR_MESSAGE);
    public static final String NEITHER_DIGIT_NOR_DELIMITER_ERROR
            = String.format("%s 숫자와 %s만 입력해야 합니다.", ERROR_MESSAGE, VIEW_DELIMITER_LABEL);
    public static final String OVER_INTEGER_RANGE_ERROR
            = String.format("%s %,d이 넘는 숫자는 입력할 수 없습니다.", ERROR_MESSAGE, Integer.MAX_VALUE);
}