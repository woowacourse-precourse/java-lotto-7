package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.LottoRank;
import lotto.model.vo.Percent;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {

    @Test
    void OF_테스트() {
        //given
        List<LottoRank> lottoRanks = List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.THIRD, LottoRank.SECOND);

        //when
        LottoStatistic lottoStatistic = LottoStatistic.of(lottoRanks);

        //then
        assertThat(lottoStatistic.getCountByLottoRank(LottoRank.FIRST))
                .isEqualTo(2);
    }

    @Test
    void 수익률_테스트() {
        //given
        List<LottoRank> lottoRanks = List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.THIRD, LottoRank.SECOND);
        LottoStatistic lottoStatistic = LottoStatistic.of(lottoRanks);

        //when
        Percent profitRate = lottoStatistic.getProfitRate();

        //then
        assertThat(new Percent(100787500.0))
                .isEqualTo(profitRate);
    }

}
