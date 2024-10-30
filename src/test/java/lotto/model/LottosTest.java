package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
