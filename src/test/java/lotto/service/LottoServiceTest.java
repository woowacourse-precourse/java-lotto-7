package lotto.service;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 구매한_로또를_평가하여_순위를_확인할_수_있다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );

        // when
        Map<LottoRank, Integer> ranks = lottoService.evaluateLottos(winningLotto, bonusNumber, lottos);

        // then
        assertThat(ranks).hasSize(3)
                .contains(
                        entry(LottoRank.FIRST, 1),
                        entry(LottoRank.SECOND, 1),
                        entry(LottoRank.THIRD, 1)
                );
    }

}
