package lotto.common;

public class ErrorMessages {
    public static final String PRICE_NULL_BLANK = "[ERROR] 가격은 공백이나 null값이 될 수 없습니다.";
    public static final String PRICE_NUMBER_ONLY = "[ERROR] 가격은 숫자만 입력할 수 있습니다.";
    public static final String PRICE_POSITIVE_ONLY = "[ERROR] 가격은 음수가 될 수 없습니다.";
    public static final String PRICE_RANGE = "[ERROR] 가격은 1000원 단위여야 합니다.";
    public static final String BONUS_NULL_BLANK = "[ERROR] 보너스 숫자는 공백이나 null값이 될 수 없습니다.";
    public static final String BONUS_NUMBER_ONLY = "[ERROR] 보너스 숫자는 숫자만 입력할 수 있습니다.";
    public static final String BONUS_NUMBER_RANGE = "[ERROR] 보너스 숫자는 1 ~ 45 범위여야 합니다.";
    public static final String BONUS_LOTTO_DUPLICATED = "[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.";
    public static final String LOTTO_NULL_BLANK = "[ERROR] 당첨 숫자는 공백이나 null값이 될 수 없습니다.";
    public static final String LOTTO_NUMBER_ONLY = "[ERROR] 당첨 숫자는 숫자만 입력할 수 있습니다.";
    public static final String LOTTO_NUMBER_RANGE = "[ERROR] 당첨 숫자는 1 ~ 45 범위여야 합니다.";
    public static final String LOTTO_DUPLICATED = "[ERROR] 당첨 숫자는 중복될 수 없습니다.";
    public static final String LOTTO_COUNT = "[ERROR] 당첨 숫자는 6개여야 합니다.";
}
