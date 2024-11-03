package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

public class LottoResultTest {


    @Test
    void 주어진_LottoRankCount와_동일한_값을_반환해야_한다(){
        Map<LottoRank, Integer> expectedRankCount = new HashMap<>();
        expectedRankCount.put(LottoRank.FIRST_PLACE, 2);
        double garbage = 0.0;

        LottoResult lottoResult = LottoResult.ofRankCountAndProfitRate(expectedRankCount, garbage);

        assertThat(lottoResult.getRankCount()).isEqualTo(expectedRankCount);
    }

    @Test
    void 주어진_수익률과_동일한_값을_반환해야_한다(){
        Map<LottoRank, Integer> garbage = new HashMap<>();
        double expectedProfitRate = 200.0;

        LottoResult lottoResult = LottoResult.ofRankCountAndProfitRate(garbage, expectedProfitRate);

        assertThat(lottoResult.getLottoProfitRate()).isEqualTo(expectedProfitRate);

    }
}
