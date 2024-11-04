package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStatisticsService 테스트")
public class LottoStatisticsServiceTest {

    private LottoStatisticsService lottoStatisticsService;

    @BeforeEach
    void setup() {
        lottoStatisticsService = new LottoStatisticsService();
    }

    @Test
    void 당첨내역과_구입금액으로_수익률을_계산한다() {
        //given
        List<LottoRank> ranks = List.of(
            LottoRank.FOURTH,
            LottoRank.FIFTH,
            LottoRank.FIFTH,
            LottoRank.MISS
        );

        int purchaseAmount = 10000;

        //when
        double profitRate = lottoStatisticsService.calculateProfitRate(ranks, purchaseAmount);

        //then
        assertThat(profitRate).isEqualTo(600.0);
    }

}
