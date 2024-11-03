package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    private final WinningNumbers winningNumbers = new WinningNumbers(
            List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("숫자가 아닌 값을 입력하는 경우 예외")
    public void notNumberException() {

        assertThatThrownBy(() -> new BonusNumber("temp", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 넘어서는 경우 예외")
    public void numberRangeException() {

        assertThatThrownBy(() -> new BonusNumber("100", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 포함되는 경우 예외")
    public void includeWinningNumberException() {

        assertThatThrownBy(() -> new BonusNumber("1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
