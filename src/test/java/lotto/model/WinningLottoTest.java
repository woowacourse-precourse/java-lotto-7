package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복일때_에러_발생() {
        assertThatThrownBy(() -> {
            // given
            Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // when
            WinningLotto winningLotto = new WinningLotto(winningNumber, 3);
        }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");
    }
}
