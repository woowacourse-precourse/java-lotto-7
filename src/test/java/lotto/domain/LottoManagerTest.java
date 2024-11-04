package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    @Test
    void matchLottoTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        int matchCount = winningLotto.matchCount(lotto);

        // then
        assertThat(matchCount).isEqualTo(6);
    }
}
