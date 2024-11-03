package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAmountTest {

    @Test
    void 로또_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoAmount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 금액은 음수가 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {900, 1010})
    void 금액이_10000원_단위가_아니면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 금액은 1000원 단위로만 가능합니다.");
    }

    @Test
    void 로또의_구매_개수를_구한다() {
        // given
        LottoAmount lottoAmount = new LottoAmount(3000);

        // when
        int purchaseLottoCount = lottoAmount.getPurchaseLottoCount();

        // then
        assertThat(purchaseLottoCount).isEqualTo(3);
    }
}
