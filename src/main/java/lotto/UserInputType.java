package lotto;

/**
 * 사용자 입력 데이터의 종류를 구분하는 enum 클래스입니다.
 */
public enum UserInputType {
    /**
     * 로또 구매금액 데이터임을 표시합니다.
     */
    PURCHASE_COST,
    /**
     * 당첨번호 데이터임을 표시합니다.
     */
    WINNING_NUMBERS,
    /**
     * 보너스 번호 데이터임을 표시합니다.
     */
    BONUS_NUMBER
}
