package lotto.validator;

import java.math.BigInteger;

public class ValidatorUtils {
    public static final String ERROR_MESSAGE = "[ERROR]";

    // 숫자 형식 확인
    public static boolean isNumber(String input) {
        return input.matches("-?\\d+");  // 정수 형식 확인 (음수 포함)
    }

    // 숫자 형식 검증 후 BigInteger로 변환
    public static BigInteger validateBigInteger(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
        return new BigInteger(input);  // 숫자 형식이 확인된 후 변환
    }

    // int 범위 내에 있는지 확인하고 초과 시 예외 처리
    public static int validateIntRange(BigInteger bigIntValue) {
        if (bigIntValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                bigIntValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력한 금액이 정수 범위를 초과합니다.");
        }
        return bigIntValue.intValue();  // int 범위 내이므로 변환 후 반환
    }
}

