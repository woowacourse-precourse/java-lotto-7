package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {
    @DisplayName("입력된 구입 금액이 1000 단위가 아닌 경우 예외가 발생한다")
    @Test
    void 입력된_구입_금액이_1000_단위가_아닌_경우_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readPurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액이 1000 미만인 경우 예외가 발생한다")
    @Test
    void 입력된_구입_금액이_1000_미만인_경우_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readPurchaseAmount("990"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 중 숫자가 아닌 다른 값이 들어올 경우 예외가 발생한다")
    @Test
    void 입력_중_숫자가_아닌_다른_값이_들어올_경우_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readPurchaseAmount("1000ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
