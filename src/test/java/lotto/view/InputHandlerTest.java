package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.view.InputHandler.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 1, 100, 1001})
    void 구입_금액이_1000의_배수가_아니면_예외_발생(int purchaseAmount) {
        assertThatThrownBy(() -> validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 1000000})
    void 구입_금액이_1000의_배수이면_예외_없음(int purchaseAmount) {
        assertDoesNotThrow(() -> {
            InputHandler.validatePurchaseAmount(purchaseAmount);
        });
    }
}
