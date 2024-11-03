package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.lotto.PurchaseAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "11000:11", "25000:25", "303000:303", "1474134000:1474134",
            "1000000000:1000000"}, delimiter = ':')
    void 금액을_1000으로_나누어_개수를_구한다(int testNumber, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(testNumber);

        assertThat(purchaseAmount.calculateLottoAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 1002, 2524, 100001, 100020})
    void 금액이_1000으로_나누어떨어지지_않으면_예외(int testNumber) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(testNumber);
        assertThatIllegalArgumentException().isThrownBy(
                        () -> purchaseAmount.calculateLottoAmount())
                .withMessage("[ERROR] 1000 단위의 금액을 입력해주세요.");
    }
}
