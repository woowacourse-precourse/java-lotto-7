package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoIssuerTest {
    @Test
    void 구입_금액이_음수인_예외() {
        assertThatThrownBy(() -> new LottoIssuer(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.format());
    }

    @Test
    void 구입_금액이_0인_예외() {
        assertThatThrownBy(() -> new LottoIssuer(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.format());
    }

    @Test
    void 구입_금액이_1000원_단위_양수가_아닌_예외() {
        assertThatThrownBy(() -> new LottoIssuer(3500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.format());
    }
}
