package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.purchase.Money;
import lotto.domain.winning.LottoProfit;
import lotto.domain.winning.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {

    @DisplayName("로또 수익률을 성공적으로 반환 한다.")
    @Test
    void getProfitRatioTest() {
        //given
        final LottoRank rank4 = LottoRank.RANK_4;
        final int count1 = 2;
        final LottoRank rank5 = LottoRank.RANK_5;
        final int count2 = 3;
        final Map<LottoRank, Integer> lottoRanks = Map.of(rank4, count1, rank5, count2);
        final Money money = new Money(5000);
        final BigDecimal totalPrice = rank4.getPrice().multiply(BigDecimal.valueOf(count1))
                .add(rank5.getPrice().multiply(BigDecimal.valueOf(count2)));
        final double ratio = money.calculateRatio(totalPrice);
        final LottoProfit lottoProfit = new LottoProfit(lottoRanks, money);
        //when
        final double profitRatio = lottoProfit.getProfitRatio();
        //then
        assertThat(profitRatio).isEqualTo(ratio);

    }
}
