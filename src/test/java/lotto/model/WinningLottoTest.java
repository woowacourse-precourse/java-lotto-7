package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 보너스_번호_중복_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_범위_바깥_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),60))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_음수_입력_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), -3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
