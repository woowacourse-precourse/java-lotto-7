package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호 개수가 6개가 아니면 예외가 발생한다.")
    void 로또_생성_실패_개수_초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_생성_실패_중복() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void 로또_생성_실패_범위_초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 67)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
