package lotto.message;

public class ExceptionMessage {
    public static final String EMPTY_INPUT_EXCEPTION = "[ERROR] 입력된 금액이 없습니다.";
    public static final String INVALID_AMOUNT_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구입 금액 입력은 숫자(양의 정수)로만 이루어져야 합니다.";
    public static final String UNDER_MIN_AMOUNT_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 최소 한장 이상 구매할 수 있는 금액을 입력하셔야 합니다. (한장 1000)";
    public static final String INVALID_AMOUNT_UNIT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액은 1000원 단위로 입력하셔야 합니다. (1000으로 나누어 떨어지도록)";
    public static final String EXCEED_MAX_AREA_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액이 최대 범위를 초과하였습니다.";

    public static final String WINNING_NUMBER_DUPLICATION_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호는 중복 될 수 없습니다.";
    public static final String WINNING_NUMBER_AREA_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호는 1~45까지의 숫자만 가능합니다.";
    public static final String INVALID_WINNING_NUMBER_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 "
            + "입력하셨습니다. 당첨 번호 입력은 숫자와 구분자(,)로만 이루어져야 합니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호 입력의 시작과 끝은 숫자로 이루어져야 합니다.";
    public static final String INVALID_SEPARATOR_NUMBER_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 구분자 사이에 반드시 숫자가 존재해야 합니다.";
    public static final String WINNING_NUMBER_LENGTH_EXCEPTION = "[ERROR] 로또 번호는 6개여야 합니다.";

    public static final String INVALID_BONUS_NUMBER_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 보너스 번호를 입력하셨습니다."
            + " 보너스 번호 입력은 숫자(양의 정수)로만 이루어져야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATION_EXCEPTION = "[ERROR] 잘못된 보너스 번호를 입력하셨습니다."
            + " 보너스 번호는 중복 될 수 없습니다.";
    public static final String BONUS_NUMBER_AREA_EXCEPTION = "[ERROR] 잘못된 보너스 번호를 입력하셨습니다."
            + " 보너스 번호는 1~45까지의 숫자만 가능합니다.";
}
