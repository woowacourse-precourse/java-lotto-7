package lotto.validator.strategies;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.view.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseAmountValidatorTest {

    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @ParameterizedTest
    @CsvSource({
            "100, PURCHASE_AMOUNT_INVALID",       // 1,000의 배수가 아닌 경우 (100)
            "5500, PURCHASE_AMOUNT_INVALID",      // 1,000의 배수가 아닌 경우 (5500)
            "12345, PURCHASE_AMOUNT_INVALID"      // 1,000의 배수가 아닌 경우 (12345)
    })
    void validate_WhenAmountIsNotMultipleOfLottoPrice_ShouldThrowException(int amount, String errorMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(amount))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1000",  // 정상 입력 (1,000의 배수)
            "5000",  // 정상 입력 (1,000의 배수)
            "20000"  // 정상 입력 (1,000의 배수)
    })
    void validate_WhenAmountIsMultipleOfLottoPrice_ShouldNotThrowException(int amount) {
        assertThatNoException().isThrownBy(() -> validator.validate(amount));
    }

}
