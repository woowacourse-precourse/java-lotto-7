package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class IssuedLottoTest {

    @Test
    void 정상적으로_생성된다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        // when
        IssuedLotto issuedLotto = new IssuedLotto(lottos);

        // then
        assertThat(issuedLotto.lottos()).isEqualTo(lottos);
    }
}