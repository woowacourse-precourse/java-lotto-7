package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
    void 구입_금액_숫자_아님_예외() {
        assertThatThrownBy(inputView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
    }
}