package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PurchaseAmountInputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", ","})
    void 구입_금액이_정수가_아니면_예외_발생(String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountInputHandler.validatePurchaseAmountIsInteger(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "1000"})
    void 구입_금액이_정수이면_예외_없음(String purchaseAmount) {
        assertDoesNotThrow(() -> {
            PurchaseAmountInputHandler.validatePurchaseAmountIsInteger(purchaseAmount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 1, 100, 1001})
    void 구입_금액이_1000의_배수가_아니면_예외_발생(int purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountInputHandler.validatePurchaseAmountIsThousandUnit(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 1000000})
    void 구입_금액이_1000의_배수이면_예외_없음(int purchaseAmount) {
        assertDoesNotThrow(() ->
                PurchaseAmountInputHandler.validatePurchaseAmountIsThousandUnit(purchaseAmount)
        );
    }
}
