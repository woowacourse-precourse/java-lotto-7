package lotto.exception;

import lotto.domain.LottoNumber;

public class ErrorMessage {
    public static final String NOT_INTEGER = "[ERROR] 정수를 입력해주세요.";
    public static final String WINNING_NUMBERS_SIZE = "[ERROR] 6개의 숫자가 필요합니다.";
    public static final String BONUS_NUMBER_INVALID = "[ERROR] 잘못된 보너스 번호입니다.";
    public static final String NEGATIVE_AMOUNT = "[ERROR] 양수 금액을 입력해주세요.";
    public static final String INVALID_DIVIDE = "[ERROR] 1000원 단위로 입력해주세요.";
    public static final String NUMBER_RANGE_INVALID = "[ERROR] " + LottoNumber.MIN_NUMBER + "~" + LottoNumber.MAX_NUMBER + "사이의 숫자를 입력해주세요.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 중복된 공입니다.";
}