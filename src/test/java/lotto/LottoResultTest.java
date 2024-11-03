package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 5등
        );
        lottoResult = new LottoResult(winningNumbers, bonusNumber, tickets);
    }

    @DisplayName("각 등수에 대한 당첨 결과를 올바르게 계산해야 한다")
    @Test
    void 등수별_당첨_결과_테스트() {
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }
}
