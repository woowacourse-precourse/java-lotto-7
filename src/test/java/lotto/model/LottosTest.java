package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @Test
    void 로또를_발행한다() {
        assertThat(lottos.createLotto().getClass())
                .isEqualTo(Lotto.class);
    }

    @Test
    void 로또를_저장한다() {
        Lotto lotto = new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        );

        lottos.saveLotto(lotto);

        assertThat(lottos.getLottoDtos()
                .get(0)
                .numbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
