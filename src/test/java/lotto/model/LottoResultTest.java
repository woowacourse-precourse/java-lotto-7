package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    @DisplayName("당첨 결과가 올바르게 계산되는지 확인한다.")
    void getResults() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), //1등
                new Lotto(List.of(7, 8, 9, 10, 11, 12)), //miss
                new Lotto(List.of(13, 14, 15, 16, 17, 18)), //miss
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), //2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), //3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)) //4등
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);

        Map<LottoRank, Integer> result = lottoResult.getResults();

        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.MISS)).isEqualTo(2);
    }
}