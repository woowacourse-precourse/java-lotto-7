package lotto.application.ticket.domain.payment.lottoPrice;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoPrice - 수량 카운트")
public class CalculateLottoCountTest {
    @Test
    @DisplayName("정상 작동")
    void 정상_작동() {
        // given
        LottoPrice lottoPrice = LottoPrice.basic();
        ThousandWons money = ThousandWons.of("2000");

        // expect
        Assertions.assertThat(lottoPrice.calculateLottoCount(money)).isEqualTo(2);
    }

}
