package exception;

/**
 * 예외 처리 관련 메시지를 담당
 */
public class Message {
    private static final String DEFAULT = "[ERROR] ";
    public static final String INVALID_MONEY = DEFAULT + "입력 금액은 %d원 단위로 입력 가능합니다. 사용자의 입력값: ".formatted(lotto.Lotto.Price.PRICE);
    public static final String INVALID_CHOICE = DEFAULT + "로또 번호는 6개여야 합니다. 사용자의 입력값: ";
    public static final String DUPLICATE_NUMBER = DEFAULT + "당첨 번호에는 중복값이 없어야 합니다. 중복값: ";
    public static final String INVALID_RANGE = DEFAULT + "번호는 1과 45 사이의 수여야 합니다. 반례: ";
    public static final String INVALID_BONUS_NUMBER = DEFAULT + "보너스 번호는 당첨 번호와 달라야 합니다. 중복값: ";
    public static final String INVALID_INPUT_STRING = DEFAULT + "입력값은 ,로 구분되는 정수의 문자열이어야 합니다. 사용자의 입력값: ";

    public String string;

    public Message(String string) {
        this.string = string;
    }

    public String getMessage(String forward) {
        return forward + this.string;
    }
}
