package lotto.model;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.LottoRank;

public class LottoRanksTest {
    @Test
    void 정상_기능_테스트() {
        // Given
        List<LottoRank> lottoRankData = List.of(LottoRank.MATCH_3, LottoRank.MATCH_6);

        // When
        LottoRanks lottoRanks = new LottoRanks(lottoRankData);

        // Then
        assertThat(lottoRanks.getLottoRanks().stream().map(LottoRank::getDescription).toList()).contains(LottoRank.MATCH_3.getDescription(), LottoRank.MATCH_6.getDescription());
    }
}
