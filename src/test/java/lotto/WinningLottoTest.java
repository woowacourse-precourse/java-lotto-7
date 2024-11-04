package lotto;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호의 범위는 1부터 45여야 한다.")
    @Test
    void 보너스_번호의_범위는_1부터_45여야_한다() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 55))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
