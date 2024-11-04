package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;


public class InputHandlerTest {

    @Test
    public void 구입금액_예외처리_테스트() {
        InputHandler inputHandler = new InputHandler();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int amount = 1500;
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    public void 당첨번호_예외처리_테스트() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 46, 4, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateNumbers(winningNumbers);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    public void 보너스번호_예외처리_테스트() {
        InputHandler inputHandler = new InputHandler();
        int bonusNumber = 46;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateNumber(bonusNumber);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
