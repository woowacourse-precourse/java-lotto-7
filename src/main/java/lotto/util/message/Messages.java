package lotto.util.message;

public class Messages {
    // 출력 메시지
    public final static String INPUT_PRICE = "구매하실 금액을 입력해 주세요.";
    public final static String QUANTITY_OF_LOTTO= "개를 구매했습니다.";
    public final static String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    // 예외 메시지
    public static final String INVALID_INPUT = "[ERROR] 숫자를 입력해야 합니다.";
    public static final String INVALID_PRICE = "[ERROR] 금액은 1000원 단위로 입력해야 합니다.";
    public static final String EMPTY_INPUT = "[ERROR] 빈 문자열을 입력하면 안됩니다.";
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";


    private Messages() {};
}
