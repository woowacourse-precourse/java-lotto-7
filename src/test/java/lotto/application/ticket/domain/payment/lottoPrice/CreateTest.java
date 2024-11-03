package lotto.application.ticket.domain.payment.lottoPrice;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoPrice - 생성")
public class CreateTest {
    @DisplayName("기본 가격으로 생성하기")
    @Test
    void 기본_가격으로_생성하기() {

        // expect
        Assertions.assertThatCode(() -> LottoPrice.basic())
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 살 수 있음")
    @Test
    void 로또_살_수_있음() {

        // given
        LottoPrice lottoPrice = LottoPrice.basic();
        ThousandWons money = ThousandWons.of("2000");

        // expect
        Assertions.assertThatCode(() -> lottoPrice.validateAffordable(money))
                .doesNotThrowAnyException();

    }

    @DisplayName("로또를 살 수 있다")
    @Test
    void 기본_가격으로_생성_하기() {

        // expect
        Assertions.assertThatCode(() -> LottoPrice.basic())
                .doesNotThrowAnyException();
    }

}
