package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class LottoValueTest {
    @Test
    void 구입금액이_1000단위로_나눠지지_않을_시_에러발생() {
        assertThatThrownBy(() -> new LottoValue(BigDecimal.valueOf(1001)))
                .hasMessage("구입금액은 1000 단위여야합니다.");
    }

    @Test
    void LottoValue_정상_생성() {
        LottoValue lottoValue = new LottoValue(BigDecimal.valueOf(2000));

        assertEquals(2000, lottoValue.lottoPrice().intValue());
        assertEquals(2, lottoValue.lottoCount());
    }
}