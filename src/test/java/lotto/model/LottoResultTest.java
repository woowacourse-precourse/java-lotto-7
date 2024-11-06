package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private final LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(1, 2, 3, 4, 5, 13),
            Arrays.asList(1, 2, 3, 4, 5, 24),
            Arrays.asList(1, 2, 3, 4, 34, 35),
            Arrays.asList(1, 2, 3, 42, 43, 44))
    );
    private final Set<Integer> winningNumbers = new HashSet<>(
            Arrays.asList(1, 2, 3, 4, 5, 6));
    private final int bonusNumber = 24;
    private Map<Rank, Integer> ranks;

    @Test
    @DisplayName("당첨 결과 계산 확인")
    void 당첨_결과_계산_확인() {
        LottoResult result = new LottoResult(lottoTickets.getTickets(), winningNumbers, bonusNumber);
        ranks = result.getRanks();

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            if (entry.getKey() == Rank.NONE) {
                continue;
            }
            assertThat(entry.getValue()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("총 수익률 계산 확인")
    void 총_수익률_계산_확인() {
        int purchaseAmount = 5000;

        Map<Rank, Integer> ranks = Map.of(Rank.FIRST, 1, Rank.SECOND, 1, Rank.THIRD, 1,
                Rank.FOURTH, 1, Rank.FIFTH, 1);
        ResultAnalysis resultAnalysis = new ResultAnalysis(ranks);

        double returnRatio = resultAnalysis.getReturnRatio(purchaseAmount);

        double expectedRatio = ((double) (Rank.FIRST.getPrice() + Rank.SECOND.getPrice() + Rank.THIRD.getPrice()
                + Rank.FOURTH.getPrice() + Rank.FIFTH.getPrice()) / purchaseAmount) * 100;

        assertThat(returnRatio).isEqualTo(expectedRatio);
    }
}
