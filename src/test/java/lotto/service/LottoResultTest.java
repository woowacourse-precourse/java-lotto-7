package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoMoney;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨_수익률_계산이_정확한지_확인한다() {
        // given
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.NO1);
        ranks.add(Rank.NO2);
        ranks.add(Rank.NO3);
        ranks.add(Rank.NO3);
        ranks.add(Rank.NO3);
        LottoMoney money = new LottoMoney(5000);

        // when
        LottoResult lottoResult = LottoResult.from(ranks);

        // then
        Assertions.assertThat(lottoResult.calculateProfit(money))
                .isEqualTo(40690000.0);

    }


}