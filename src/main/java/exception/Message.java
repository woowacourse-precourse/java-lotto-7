package exception;

public class Message {
    private final static String DEFAULT = "[ERROR] ";
    public final static String INVALID_MONEY = DEFAULT + "입력 금액은 1000원 단위로 입력 가능합니다. 사용자의 입력값: ";
    public final static String INVALID_CHOICE = DEFAULT + "로또 번호는 6개여야 합니다. 사용자의 입력값: ";

    public String string;

    public Message(String string) {
        this.string = string;
    }

    public String getMessage(String forward) {
        return forward + this.string;
    }
}
