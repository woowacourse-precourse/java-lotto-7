package lotto.common;

public class Consts {

    public static final int LOTTO_PRICE = 1_000;
    public static final String ERROR_PREFIX = "[ERROR]";

    //TODO: ERROR 메세지는 변수 이름 앞에 ERROR 붙이기
    public static final String INPUT_MUST_BE_NUMBER_ERROR = "금액은 숫자로 입력해야 합니다.";
    public static final String PURCHASE_AMOUNT_1000_UNIT_ERROR = String.format("금액은 %d원 단위로 입력해 주세요.", LOTTO_PRICE);
    public static final String INPUT_MUST_BE_POSITIVE_NUMBER_ERROR = "금액은 음수일 수 없습니다.";
    public static final String WINNING_NUMBER_NOT_DUPLICATED_ERROR = "당첨 번호는 중복되면 안됩니다.";

    //TODO: 입력 메세지는 INPUT_MESSAGE를 변수명 앞에 계속 붙여도 되겠다.
    public static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    //TODO: 등수 별 상금
    public static final int FIRST_PRIZE_MONEY = 2_000_000_000;
    public static final int SECOND_PRIZE_MONEY = 30_000_000;
    public static final int THIRD_PRIZE_MONEY = 1_500_000;
    public static final int FOURTH_PRIZE_MONEY = 50_000;
    public static final int FIFTH_PRIZE_MONEY = 5_000;


}
