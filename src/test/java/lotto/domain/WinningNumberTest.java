package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    void 당첨번호_생성() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 당첨번호_중복_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_개수_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_번호범위_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(
                IllegalArgumentException.class);
    }
}
