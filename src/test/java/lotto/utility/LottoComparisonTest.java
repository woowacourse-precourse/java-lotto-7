package lotto.utility;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.utility.LottoComparison;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoComparisonTest {
    @DisplayName("로또 번호를 비교하여 등수를 반환한다.")
    @Test
    void 로또_번호를_비교하여_등수를_반환한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoRank rank = LottoComparison.compareLottoNumbers(winningNumbers, bonusNumber, userLotto.getNumbers());

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("총 수익률 계산")
    @Test
    void 총수익률을_계산한다() {
        Map<LottoRank, Integer> rankCounts = Map.of(
                LottoRank.FIFTH, 2,
                LottoRank.FOURTH, 1,
                LottoRank.THIRD, 1
        );
        int purchaseAmount = 1000;

        double profitRate = LottoComparison.calculateProfitRate(rankCounts, purchaseAmount);

        assertThat(profitRate).isEqualTo(110.0);
    }
}
