package lotto.enums;

public enum ErrorMessage {

    INPUT_NULL("아무런 값을 입력하지 않았습니다."),
    INPUT_ZERO("0을 입력하였습니다."),

    PRICE_UNDER_THOUSAND("1000원 이상의 금액을 입력해야 됩니다."),
    PRICE_NOT_DIVIDE_THOUSAND("1000원 단위로 입력해야 됩니다."),

    SEPARATOR_NOT_COMMA("구분자는 쉼표만 가능합니다."),
    NOT_ALLOW_SEPARATOR_CONTINUE("쉼표는 2개 이상 연속적으로 입력될 수 없습니다."),
    NOT_ALLOW_NUMBER_BLANK("쉼표로 구분된 수가 공백일 수는 없습니다."),
    NOT_INPUT_SIX_NUMBERS("6개의 숫자를 입력해주세요."),
    NOT_ALLOW_START_WITH_ZERO("숫자는 0으로 시작될 수 없습니다."),
    NOT_ALLOW_DUPLICATE_NUMBER("숫자는 중복을 허용하지 않습니다."),
    ALLOW_ONE_TO_FORTY_FIVE("입력된 수에 1~45 범위의 수가 포함되어 있습니다."),
    NOT_ALLOW_WITHOUT_NUMBER("숫자 이외의 값은 입력할 수 없습니다."),
    ALREADY_DUPLICATE_NUMBER("이미 당첨 번호와 중복되는 번호입니다."),
    NOT_ALLOW_WITHOUT_NUMBER_AND_COMMA("숫자와 쉼표 이외의 값은 입력할 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return Delimiter.ERROR.getDelimiter() + errorMessage;
    }
}
