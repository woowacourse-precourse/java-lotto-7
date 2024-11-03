package lotto.constant;

public class OutputMessage {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String PURCHASE_PRICE_REQUEST = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_QUANTITY_FORMAT = LINE_SEPARATOR + "%d개를 구매했습니다.";
    public static final String MAIN_NUMBERS_REQUEST = LINE_SEPARATOR + "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_REQUEST = LINE_SEPARATOR + "보너스 번호를 입력해 주세요.";
    public static final String WINNING_RESULT_PREFIX = LINE_SEPARATOR + "당첨 통계" + LINE_SEPARATOR + "---" + LINE_SEPARATOR;
    public static final String RATE_OF_RETURN_FORMAT = LINE_SEPARATOR + "총 수익률은 %.2f%%입니다.";

    private OutputMessage() {
    }
}
