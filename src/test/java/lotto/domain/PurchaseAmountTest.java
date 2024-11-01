package lotto.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseAmountTest {
    @BeforeEach
    void setupTestEnvironment() {
        System.setProperty("IS_TEST_ENV", "true");
    }

    @AfterEach
    void resetTestEnvironment() {
        System.clearProperty("IS_TEST_ENV");
    }

    @ParameterizedTest
    @DisplayName("구입 불가능 금액 예외 확인")
    @ValueSource(ints = {999, 0, 10, 101000, 1000000})
    void checkPurchaseBoundaryOverError(int test) {
        PurchaseAmount.resetInstance();
        String errorMessage = "[ERROR] 구입 금액은 1_000이상 100_000 이하의 값만 가능합니다.";

        assertThatThrownBy(() -> PurchaseAmount.getPurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 금액 1000원 단위 예외 확인")
    @ValueSource(ints = {7777, 10001, 1100})
    void checkNotMultipleOfThousandError(int test) {
        PurchaseAmount.resetInstance();
        String errorMessage = "[ERROR] 구입 금액은 1000원 단위로만 가능합니다.";

        assertThatThrownBy(() -> PurchaseAmount.getPurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 금액 확인")
    @ValueSource(ints = {1000, 10000, 100000, 5000, 70000})
    void checkSuccessPurchaseAmount(int test) {
        PurchaseAmount.resetInstance();
        PurchaseAmount purchaseAmount = PurchaseAmount.getPurchaseAmount(test);

        assertEquals(purchaseAmount.getPurchaseAmount(), test);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 횟수 확인")
    @ValueSource(ints = {1000, 10000, 100000, 5000, 70000})
    void checkSuccessPurchaseCount(int test) {
        PurchaseAmount.resetInstance();
        int successPurchaseCount = test / 1000;
        PurchaseAmount purchaseAmount = PurchaseAmount.getPurchaseAmount(test);

        assertEquals(purchaseAmount.getPurchaseCount(), successPurchaseCount);
    }
}
