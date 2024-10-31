package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseAmountTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @ParameterizedTest
    @DisplayName("구입 불가능 금액 예외 확인")
    @ValueSource(strings = {"999", "0", "10", "101000", "1000000"})
    void checkPurchaseBoundaryOverError(String test) {
        String errorMessage = "[ERROR] 구입 금액은 1000이상 100000 이하의 값만 가능합니다.";

        assertThatThrownBy(() -> new PurchaseAndWinRecord(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 금액 1000원 단위 예외 확인")
    @ValueSource(strings = {"7777", "10001", "1100"})
    void checkNotMultipleOfThousandError(String test) {
        String errorMessage = "[ERROR] 구입 금액은 1000원 단위로만 가능합니다.";

        assertThatThrownBy(() -> new PurchaseAndWinRecord(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 금액 확인")
    @ValueSource(strings = {"1000", "10000", "100000", "5000", "70000"})
    void checkSuccessPurchaseAmount(String test) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(test);

        assertEquals(purchaseAmount.getPurchaseAmount(), test);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 횟수 확인")
    @ValueSource(strings = {"1000", "10000", "100000", "5000", "70000"})
    void checkSuccessPurchaseCount(String test) {
        int successPurchaseCount = Integer.parseInt(test) / 1000;
        PurchaseAmount purchaseAndWinRecord = new PurchaseAmount(test);

        assertEquals(purchaseAmount.getpurchaseAmount(), successPurchaseCount);
    }
}
