package lotto;

/**
 * 사용자 입력에 대한 안내메세지를 관리하는 클래스입니다.
 */
public class InputMessageFactory {
    private static final String QUERY_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String QUERY_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUERY_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    
    /**
     * 사용자 입력 종류에 따라 적절한 안내메세지를 반환합니다.
     * @param inputType 사용자 입력 종류
     * @return 안내메세지가 담긴 String 객체
     */
    public static String getInputMessage(UserInputType inputType) {
        if (inputType == UserInputType.PURCHASE_COST) {
            return QUERY_PURCHASE_COST;
        }
        if (inputType == UserInputType.WINNING_NUMBERS) {
            return QUERY_WINNING_NUMBERS;
        }
        if (inputType == UserInputType.BONUS_NUMBER) {
            return QUERY_BONUS_NUMBERS;
        }
        throw new UnsupportedOperationException("알 수 없는 입력 형식입니다! : " + inputType.toString());
    }
}
