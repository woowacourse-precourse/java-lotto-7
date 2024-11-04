package lotto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentValidatorTest {

    PaymentValidator paymentValidator = new PaymentValidator();

    @DisplayName("올바른 구입 금액을 검증한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "1000",
            "1000.0",
            "10000",
            "12000.00000000000",
            "1000.",
    })
    void validPaymentInputTest(String paymentInput) {
        Assertions.assertTrue(paymentValidator.validate(paymentInput));
    }

    @DisplayName("잘못된 구입 금액을 검증한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "100",
            "999",
            "9999999999999999999",
            "1000i",
            "-1000",
            "1000.2",
            "12000.00000000002",
            "",
            "1000.00.00",
            ".0"
    })
    void invalidPaymentInputTest(String paymentInput) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> paymentValidator.validate(paymentInput));
    }
}
