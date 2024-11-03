package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProfitRateTest {

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void 수익률_계산하기() {
        Money originMoney = Money.of(1000);
        int totalProfits = 1500;

        ProfitRate profitRate = ProfitRate.from(totalProfits, originMoney);
        assertThat(profitRate.getRate()).isEqualTo(BigDecimal.valueOf(150.0).setScale(3));
    }

    @DisplayName("원금이 0일 때 수익률은 0이다.")
    @Test
    void 원금이_0일_때_수익률은_0이다() {
        Money originMoney = Money.of(0);
        int totalProfits = 1500;

        ProfitRate profitRate = ProfitRate.from(totalProfits, originMoney);

        assertThat(profitRate.getRate()).isEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("원금이 null일 때 LottoException을 던진다.")
    @Test
    void 원금이_null일_때_LottoException을_던진다() {
        Money originMoney = null;
        int totalProfits = 1500;

        assertThatThrownBy(() -> ProfitRate.from(totalProfits, originMoney))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessages.ORIGIN_MONEY_NULL.getMessage());
    }

    @DisplayName("총 수익이 0일 때 수익률은 0이다.")
    @Test
    void 총_수익이_0일_때_수익률은_0이다() {
        Money originMoney = Money.of(1000);
        int totalProfits = 0;

        ProfitRate profitRate = ProfitRate.from(totalProfits, originMoney);

        assertThat(profitRate.getRate()).isEqualTo(BigDecimal.ZERO.setScale(3));
    }

    @DisplayName("수익률은 음수일 수 없다.")
    @Test
    void 수익률은_음수일_수_없다() {
        Money originMoney = Money.of(1000);
        int totalProfits = -500;

        ProfitRate profitRate = ProfitRate.from(totalProfits, originMoney);

        assertThat(profitRate.getRate()).isEqualTo(BigDecimal.ZERO);
    }
}
