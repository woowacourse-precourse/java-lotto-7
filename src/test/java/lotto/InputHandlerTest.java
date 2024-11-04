package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위 바깥의 숫자가 포함되면 예외가 발생한다")
    @Test
    void 당첨_번호에_범위_바깥의_숫자가_포함되면_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readWinningNumbers("1,2,3,4,5,60"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 갯수가 맞지 않으면 예외가 발생한다")
    @Test
    void 당첨_번호_갯수가_맞지_않으면_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readWinningNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위 바깥의 숫자가 포함되면 예외가 발생한다")
    @Test
    void 보너스_번호에_범위_바깥의_숫자가_포함되면_예외가_발생한다() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.readBonusNumber("70"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
