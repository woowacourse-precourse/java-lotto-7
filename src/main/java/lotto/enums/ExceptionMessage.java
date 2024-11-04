package lotto.enums;

// 에러 메세지 관리 열거 클래스
public enum ExceptionMessage {
    PRICE_NOT_VALID_FORMAT("금액은 1000 이상의 숫자 하나만 입력 할 수 있습니다."),
    PRICE_IS_NULL("구입금액 NULL 오류 입니다."),
    PRICE_OUT_OF_RANGE(String.format("금액은 %d 범위를 벗어날 수 없습니다.", Integer.MAX_VALUE)),
    PRICE_NOT_MULTIPLE_OF_THOUSAND("1000원 단위의 금액을 입력해주세요."),
    WINNING_NUMBER_IS_NULL("당첨 번호 NULL 오류입니다."),
    WINNING_NUMBER_NOT_VALID_FORMAT("당첨 번호는 1 ~ 45 사이의 숫자와 쉼표만 입력 할 수 있습니다. (공백 없이 쉼표로만 숫자 구분)"),
    WINNING_NUMBER_START_OR_END_WITH_COMMA("당첨 번호는 쉼표로 시작하거나 끝날 수 없습니다."),
    WINNING_NUMBER_HAS_CONTINUOUS_COMMA("당첨 번호는 쉼표 사이에는 숫자를 입력해 주세요."),
    WINNING_NUMBER_OUT_OF_RANGE(String.format("당첨 번호는 %d 범위를 벗어 날 수 없습니다.", Integer.MAX_VALUE)),
    BONUS_NUMBER_IS_NULL("보너스 번호 NULL 오류 입니다."),
    BONUS_NUMBER_NOT_VALID_FORMAT("보너스 번호는 숫자만 입력 할 수 있습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1 ~ 45 사이의 숫자이어야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호 6개는 중복 될 수 없습니다."),
    LOTTO_NUMBER_NOT_VALID_COUNT("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1 ~ 45 사이의 숫자이어야 합니다."),
    WINNING_BONUS_NUMBER_DUPLICATED("당첨 번호와 보너스 번호는 중복 될 수 없습니다.");


    private final String HEADER = "[ERROR] ";
    private final String LINE_BREAK = "\n";
    private final String message;

    private ExceptionMessage(String message) {
        this.message = HEADER + message + LINE_BREAK;
    }

    public String getMessage() {
        return message;
    }
}
