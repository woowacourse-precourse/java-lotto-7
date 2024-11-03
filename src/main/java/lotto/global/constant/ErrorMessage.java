package lotto.global.constant;

import static lotto.global.constant.Config.*;

public class ErrorMessage {
    public static final String LOTTO_NUMBER_OUT_OF_SIZE = "[ERROR] 로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.";
    public static final String DUPLICATE_NUMBER_EXIST = "[ERROR] 중복된 숫자가 있습니다.";
    public static final String NUMBER_FORMAT_PROBLEM = "[ERROR] 숫자 형식이 아닙니다.";
    public static final String LOTTO_PRICE_DIVISIBILITY = "[ERROR] 구입 가격이 " + LOTTO_PRICE + "나눠떨어지지 않습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호가 지정된 숫자 범위를 넘어갑니다.";
    public static final String DIVISION_BY_ZERO = "[ERROR] 분모로 0이 나올 수 없습니다.";
    public static final String PRICE_CAN_NOT_BE_ZERO = "[ERROR] 구입 가격은 0이 나올 수 없습니다.";
    public static final String PRICE_CAN_NOT_BE_MINUS = "[ERROR] 구입 가격은 음수가 나올 수 없습니다.";
}