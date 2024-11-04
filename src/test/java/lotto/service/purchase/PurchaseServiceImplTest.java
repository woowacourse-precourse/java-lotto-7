package lotto.service.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.RandomNumbersSelector;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseServiceImplTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 55555, 999999})
    void 구입할_금액이_로또금액과_맞아떨어지지_않으면_예외가_발생한다(int payAmount) throws Exception {
        PurchaseServiceImpl purchaseService = new PurchaseServiceImpl(new RandomNumbersSelector());
        assertThatThrownBy(() -> purchaseService.purchase(payAmount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}