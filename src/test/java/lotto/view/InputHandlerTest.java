package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 1, 100, 1001})
    void 구입_금액이_1000의_배수가_아니면_예외_발생(int purchaseAmount) {
        Assertions.assertThatThrownBy(() -> validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }
}
