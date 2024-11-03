package lotto.domain.round;

import java.util.List;
import lotto.domain.core.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRoundResultTest {

    @Test
    @DisplayName("로또 등수를 올바르게 관리한다.")
    void 로또_등수를_올바르게_관리한다() {
        // Given
        List<LottoRank> lottoRanks = List.of(
                LottoRank.MATCH_THREE_NUMBER,
                LottoRank.MATCH_FOUR_NUMBER,
                LottoRank.MATCH_THREE_NUMBER);

        // When
        LottoRoundResult result = new LottoRoundResult(lottoRanks);

        // Then
        Assertions.assertThat(result.getRankCount(LottoRank.MATCH_THREE_NUMBER))
                .isEqualTo(2);
        Assertions.assertThat(result.getRankCount(LottoRank.MATCH_FOUR_NUMBER))
                .isEqualTo(1);
    }
}