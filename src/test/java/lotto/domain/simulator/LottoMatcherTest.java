package lotto.domain.simulator;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    private LottoMatcher lottoMatcher;
    private WinningNumbers winningNumbers;
    private List<Lotto> lottos;

    @BeforeEach
    void 초기화() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // First(6)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // Second(5 + 1)
                new Lotto(List.of(1, 2, 3, 4, 5, 10)), // Third(5)
                new Lotto(List.of(1, 2, 3, 4, 7, 8)), // Fourth(4 + 1)
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // Fourth(4)
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // Fifth(3 + 1)
                new Lotto(List.of(1, 2, 3, 9, 10, 11)), // Fifth(3)
                new Lotto(List.of(1, 2, 7, 10, 11, 12)), // None(2 + 1)
                new Lotto(List.of(1, 2, 9, 10, 11, 12)), // None(2)
                new Lotto(List.of(1, 7, 8, 10, 11, 12)), // None(1 + 1)
                new Lotto(List.of(1, 8, 9, 10, 11, 12)), // None(1)
                new Lotto(List.of(7, 8, 9, 10, 11, 12)), // None(0 + 1)
                new Lotto(List.of(12, 13, 14, 15, 16, 17)) // None(0)
        );

        lottoMatcher = new LottoMatcher(lottos, winningNumbers);
    }

    @DisplayName("LottoMatcher가 당첨 횟수를 정확히 관리하는지 확인하기")
    @Test
    void LottoMatcher가_당첨_횟수를_정확히_관리하는지_확인하기() {
        Map<Rank, Integer> rankCounts = lottoMatcher.getRankCounts();

        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FOURTH)).isEqualTo(2);
        assertThat(rankCounts.get(Rank.FIFTH)).isEqualTo(2);
    }
}
