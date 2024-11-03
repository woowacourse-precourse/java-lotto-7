package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("당첨 번호가 6개가 아니거나, 중복되거나, 범위를 벗어나면 예외 발생")
    void 당첨_번호_유효성_검증() {
        assertThatThrownBy(() -> inputView.parseAndValidateWinningNumbers("1, 2, 3, 3, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");

        assertThatThrownBy(() -> inputView.parseAndValidateWinningNumbers("1, 2, 3, 4, 5, 46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> inputView.parseAndValidateWinningNumbers("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
    void 보너스_번호_유효성_검증() {
        assertThatThrownBy(() -> inputView.validateBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> inputView.validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }
}
