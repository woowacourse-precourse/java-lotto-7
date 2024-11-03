package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 번호 개수를 넘어서는 경우 예외")
    public void lottoSizeException() {

        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되는 경우 예외")
    public void lottoDuplicationException() {

        assertThatThrownBy(() -> new WinningNumbers(List.of(1,1,1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 넘어서는 경우 예외")
    public void numberRangeException() {

        assertThatThrownBy(() -> new WinningNumbers(List.of(100,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
