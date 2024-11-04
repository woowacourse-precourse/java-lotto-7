package lotto;

public class Constants {
    // 로또 구매 금액 단위
    public static final int PRICE_UNIT = 1000;

    // 입출력 메시지
    public static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PRINT_LOTTO_PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    public static final String PRINT_RESULT_STATICS = "당첨 통계\n---";
    public static final String PRINT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    // 에러메시지
    public static final String NOT_NUMBER = "[ERROR] 로또 구입금액은 숫자만 입력 가능합니다.";
    public static final String NOT_PRICE_UNIT = "[ERROR] 로또 구입금액은 1000단위로 입력해야 합니다.";
    public static final String NOT_INPUT_COMMA = "[ERROR] 로또 번호는 쉼표(,)로 구분하여 입력하여야 합니다.";
    public static final String WRONG_RANGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자만 입력 가능합니다.";
    public static final String WRONG_LENGTH = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 로또 번호에 중복된 번호가 있습니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 로또 보너스번호는 당첨 번호를 제외한 숫자만 입력 가능합니다.";
}
