/*
 * 클래스 이름 ErrorMessage
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.constant;

public class ErrorMessage {
    public static final String READ_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";
    public static final String UNIT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 구입 금액는 로또 가격단위로 나누어 떨어져야 합니다.";
    public static final String PURCHASE_AMOUNT_MAX_ERROR_MESSAGE = "[ERROR] 구입 금액의 최대 금액을 초과 했습니다.";
    public static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복되지 않는 숫자만 가능합니다.";
    public static final String BONUS_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
}
