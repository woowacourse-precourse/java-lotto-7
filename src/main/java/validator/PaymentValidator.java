package validator;

import lotto.ErrorMessage;

// 구매금액의 유효성을 검증하는 클래스
// 1. 1000의 배수인가
// (추가로 검증할 부분 있는지 더블체크)
public class PaymentValidator {
    public static void validate(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_ERROR_IN_MULTIPLE_OF_THOUSAND);
        }
    }
}
