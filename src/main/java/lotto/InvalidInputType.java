package lotto;

/**
 * 부적절한 사용자 입력의 종류를 나타냅니다.
 */
public enum InvalidInputType {
    /**
     * 구매 금액이 숫자가 아님
     */
    PURCHASE_COST_NOT_NUMBER,
    /**
     * 구매 금액이 1,000원 미만 또는 음수임
     */
    PURCHASE_COST_TOO_LOW,
    /**
     * 구매 금액이 1,000원 단위가 아님
     */
    PURCHASE_COST_NOT_THOUSANDS,
    
    /**
     * 로또 번호가 숫자가 아님
     */
    LOTTO_NUMBER_NOT_NUMBER,
    /**
     * 로또 번호의 갯수가 올바르지 않음
     */
    LOTTO_NUMBER_SIZE_INCORRECT,
    /**
     * 로또 번호에 중복되는 숫자가 존재
     */
    LOTTO_NUMBER_DUPLICATED,
    /**
     * 로또 번호가 1~45 사이 숫자가 아님
     */
    LOTTO_NUMBER_INVALID
}
