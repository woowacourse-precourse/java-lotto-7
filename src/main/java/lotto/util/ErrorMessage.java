package lotto.util;

public class ErrorMessage {
    public static final String LOTTO_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_LANGE = "[ERROR] 로또 번호는 1이상 45이하여야 합니다.";
    public static final String LOTTO_NOT_UNIQUE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    public static final String INPUT_NULL = "[ERROR] 사용자 입력이 비어있습니다.";
    public static final String INPUT_NOT_NUMBER = "[ERROR] 로또 번호를 숫자로 입력해 주세요.";
    public static final String BONUS_NOT_NUMBER = "[ERROR] 보너스 번호를 숫자로 입력해 주세요.";
    public static final String BONUS_LANGE = "[ERROR] 보너스 번호를 1~45사이 정수로 입력해 주세요.";
    public static final String BONUS_NOT_UNIQUE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    public static final String PURCHASE_NOT_NUMBER = "[ERROR] 숫자만 입력해 주세요.";
    public static final String PURCHASE_UNIT = "[ERROR] 1000원 단위로 입력해 주세요.";
}
