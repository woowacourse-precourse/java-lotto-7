package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    void 당첨번호_생성() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 당첨번호_중복_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_개수_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_번호범위_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_보너스번호_중복_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
