package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_예외_처리() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

}