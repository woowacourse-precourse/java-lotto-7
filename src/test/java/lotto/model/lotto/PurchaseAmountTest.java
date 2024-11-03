package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.common.Exceptions;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {
    @Test
    @DisplayName("[success] 구매 금액을 저장한다.")
    void savePurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);

        assertThat(purchaseAmount.purchaseAmount()).isEqualTo(10000);
    }

    @ParameterizedTest
    @DisplayName("[success] 금액을 1000으로 나누어 개수를 구한다.")
    @CsvSource(value = {"1000:1", "5000:5", "11000:11", "25000:25", "303000:303", "1474134000:1474134",
            "1000000000:1000000"}, delimiter = ':')
    void calculateLottoAmountByDivision(int testNumber, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(testNumber);

        int lottoAmount = purchaseAmount.calculateLottoAmount();

        assertThat(lottoAmount).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("[fail] 금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {1, 10, 1002, 2524, 100001, 100020})
    void fail_IfPurchaseAmountNotDivisableByLottoPrice(int testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new PurchaseAmount(testNumber))
                .withMessage(Exceptions.NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
    }
}
