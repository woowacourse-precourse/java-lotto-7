package lotto.application.ticket.domain.payment.lottoQuantity;

import lotto.application.ticket.domain.payment.LottoQuantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoQuantity - 조회")
public class GetValueTest {

    @DisplayName("생성시 지정한 수량을 반환")
    @Test
    void 지정된_수량_반환() {
        // given
        int expected = 5;
        LottoQuantity quantity = LottoQuantity.of(expected);

        // expect
        Assertions.assertThat(quantity.getValue()).isEqualTo(expected);
    }

}
