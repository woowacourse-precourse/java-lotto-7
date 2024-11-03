package lotto;

// 에러 메시지의 상수
public class ErrorMessage {
    public static final String PRIZE_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨번호가 1~45 범위가 아닙니다.";
    public static final String PRIZE_COUNT_OUT_OF_SIX = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String PRIZE_NUMBER_DUPLICATION = "[ERROR] 로또 당첨 번호가 중복 되었습니다.";
    public static final String PAYMENT_ERROR_IN_MULTIPLE_OF_THOUSAND = "[ERROR] 지불한 금액이 천의 배수가 아닙니다.";
    public static final String BONUS_AND_PRIZE_NUMBER_DUPLICATION = "[ERROR] 로도 당첨 번호와 보너스 번호가 중복 되었습니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE =  "[ERROR] 보너스 번호가 1~45 범위가 아닙니다.";
}
