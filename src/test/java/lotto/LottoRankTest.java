package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("기능 테스트")
    @Test
    void 기능_테스트() {
        // Given
        int matchCount = 5;
        boolean bonusMatch = false;

        // When
        LottoRank lottoRank = LottoRank.calculateRank(matchCount, bonusMatch);

        // Then
        LottoRank expects = LottoRank.SECOND;
        assertThat(lottoRank).isEqualTo(expects);
    }
}
