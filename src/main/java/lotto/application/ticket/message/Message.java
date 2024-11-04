package lotto.application.ticket.message;

public class Message {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NEED_MORE_MONEY = ERROR_PREFIX + "구매 가능한 금액이 부족합니다.";
    public static final String CANT_NULL_ID = ERROR_PREFIX + "티켓 ID는 null일 수 없습니다.";
    public static final String CANT_NULL_LOTTO = ERROR_PREFIX + "로또 목록은 null일 수 없습니다.";
    public static final String CANT_EMPTY_LOTTO = ERROR_PREFIX + "로또 목록은 비어있을 수 없습니다.";
    public static final String INVALID_SIZE_MESSAGE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBER_MESSAGE = ERROR_PREFIX + "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_RANGE_MESSAGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String MAXIMUM_QUANTITY_ERROR = ERROR_PREFIX + "로또 수량은 100개를 초과할 수 없습니다.";
    public static final String MINIMUM_QUANTITY_ERROR = ERROR_PREFIX + "로또 수량은 1개 이상이어야 합니다.";

    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    public static final String LOTTO_FORMAT = "[%s]";
    public static final String NUMBER_DELIMITER = ", ";
    public static final String EMPTY_STRING = "";


}
