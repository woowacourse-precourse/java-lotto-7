package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStatisticsDto 테스트")
public class LottoStatisticsDtoTest {

    @Test
    void 당첨내역으로_당첨통계를_생성한다() {
        // given
        double profitRate = 50.0;
        List<LottoRank> ranks = List.of(
            LottoRank.FIFTH,
            LottoRank.MISS
        );

        // when
        LottoStatisticsDto lottoStatisticsDto = LottoStatisticsDto.of(profitRate, ranks);

        // then
        assertThat(lottoStatisticsDto.profitRate()).isEqualTo(50.0);
        assertThat(lottoStatisticsDto.firstCount()).isEqualTo(0);
        assertThat(lottoStatisticsDto.secondCount()).isEqualTo(0);
        assertThat(lottoStatisticsDto.thirdCount()).isEqualTo(0);
        assertThat(lottoStatisticsDto.fourthCount()).isEqualTo(0);
        assertThat(lottoStatisticsDto.fifthCount()).isEqualTo(1);
    }

}
