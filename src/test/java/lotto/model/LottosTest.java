package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void 구매한_로또들의_개수를_반환한다() {
        assertSimpleTest(() -> {
            Lottos lottos = new Lottos(List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 6))
            ));
            assertThat(lottos.size()).isEqualTo(2);
        });
    }

    @Test
    void 구매한_로또들의_총_가격을_반환한다() {
        assertSimpleTest(() -> {
            Lottos lottos = new Lottos(List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 6))
            ));
            assertThat(lottos.amount()).isEqualTo(2000);
        });
    }
}
