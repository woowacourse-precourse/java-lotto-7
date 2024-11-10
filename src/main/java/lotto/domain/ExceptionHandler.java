package lotto.domain;

/**
 * 엣지 케이스
 *   쉼표를 포함하여 구입 금액을 입력하는 경우 (예: 1,400) NumberFormatException
 *   문자열을 포함하여 입력하는 경우 (예: 만원, 1만원, 10,000원) NumberFormatException
 *   중복된 숫자가 포함된 경우 : IllegalStateException
 *   구매 가능 범위를 초과한 경우 (최대 10만원) : IllegalArgumentException
 *   입력 수가 6개가 넘어가는 경우 : OutOfRangeException
 */
public class ExceptionHandler {



}
