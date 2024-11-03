package lotto.common;

public class Constants {
    // prompt
    public static String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

    // number
    public static Long MAX_PURCHASE_AMOUNT = (long) Integer.MAX_VALUE;
    public static Integer LOTTO_PRICE_UNIT = 1000;

    // error message
    public static String ERROR_PROMPT = "[ERROR] ";
    public static String INVALID_PRICE_UNIT = "구입 금액은 1,000원 단위의 숫자여야 합니다.";
    public static String UP_MAX_PURCHASE_AMOUNT = "구입 금액은 2,147,483,000을 넘을 수 없습니다.";
}
