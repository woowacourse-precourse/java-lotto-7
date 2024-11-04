package lotto.constant;

import static lotto.constant.LottoValueConstant.MAX_PRICE;

public class LottoErrorConstant {
    public static final String ERROR_WINNING_NUMBER_ONLY_NUMBERS = "당첨 번호는 숫자만 입력할 수 있습니다.";
    public static final String ERROR_WINNING_NUMBER_NO_WHITESPACE = "당첨 번호에 공백을 포함할 수 없습니다.";
    public static final String ERROR_PRICE_NUMBER_FORMAT = "금액은 숫자 형식으로 입력해주세요. ex) 5000";
    public static final String ERROR_PRICE_MULTIPLE_OF_PRICE = "금액은 1000원 단위로 입력해 주세요.";
    public static final String ERROR_BONUS_NUMBER_ONLY_ONE = "보너스 번호는 한개의 숫자만 허용됩니다. ex) 5";
    public static final String ERROR_LOTTO_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_RANGE = "로또 번호는 1에서 45 사이여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_NO_DUPLICATES = "로또 번호는 중복될 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_RANGE = "보너스 번호는 1~45 사이여야 합니다.";
    public static final String ERROR_BONUS_NUMBER_NO_DUPLICATES = "보너스 번호는 당첨 번호와 중복 될수 없습니다.";

    public static final String ERROR_EXCEED_PRICE = String.format("최대 %,d원 까지 구매할 수 있습니다.",MAX_PRICE);

}
