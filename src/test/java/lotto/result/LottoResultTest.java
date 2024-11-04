package lotto.result;


import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class LottoResultTest {

    @DisplayName("로또 결과 통계를 계산한다.")
    @Test
    void 로또_결과_통계_계산() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> statistics = result.getStatistics();

        Assertions.assertThat(statistics.get(LottoRank.FIRST)).isEqualTo(1);
        Assertions.assertThat(statistics.get(LottoRank.SECOND)).isEqualTo(1);
        Assertions.assertThat(statistics.get(LottoRank.FOURTH)).isEqualTo(1);
    }
}