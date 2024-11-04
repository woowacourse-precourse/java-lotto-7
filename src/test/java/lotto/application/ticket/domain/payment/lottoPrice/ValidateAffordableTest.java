package lotto.application.ticket.domain.payment.lottoPrice;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoPrice - 구매 가능 검증")
public class ValidateAffordableTest {

    @Test
    @DisplayName("천원 객체 받으면 검증 성공")
    void 천원_객체_받으면_검증성공() {
        // given
        LottoPrice lottoPrice = LottoPrice.basic();
        ThousandWons money = ThousandWons.of("2000");

        Assertions.assertThatCode(() -> lottoPrice.validateAffordable(money))
                .doesNotThrowAnyException();
    }


}
