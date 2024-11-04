package lotto.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 로또_리스트_생성_테스트() {
        // given
        final Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        final Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // then
        assertThat(lottos.lottos().size()).isEqualTo(2);
    }
}
