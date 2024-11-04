package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 로또_목록에_추가된_로또_개수를_확인한다() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    void 구매한_로또와_당첨_번호를_비교하여_당첨_결과를_반환한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        Map<LottoRank, Integer> result = lottos.calculateRank(winningLotto, 7); // 보너스 번호 포함

        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRank.NONE)).isEqualTo(1);
    }

}
