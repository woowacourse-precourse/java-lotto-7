package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.constant.LottoTestConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasedLottoTest {

    @Test
    public void 금액에_따른_로또_구입_테스트() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(8000);
        int expectedLottoCount = 8;

        assertThat(purchasedLotto.getPurchasedLotto().size()).isEqualTo(expectedLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {2024, 10, -1, 0})
    public void 금액_예외_테스트(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchasedLotto(money))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }
}