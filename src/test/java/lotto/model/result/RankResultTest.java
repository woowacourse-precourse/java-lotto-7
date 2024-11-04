package lotto.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankResultTest {

    @DisplayName("Rank를 계산하여 총 상금을 계산한다.")
    @Test
    void 총_상금을_계산한다() {
        RankResult rankResult = RankResult.initiate();
        rankResult.compute(Rank.FIRST);
        rankResult.compute(Rank.FIFTH);
        Money totalPrize = rankResult.calculateTotalPrize();
        assertThat(totalPrize.getValue()).isEqualTo(2000005000);
    }
}
