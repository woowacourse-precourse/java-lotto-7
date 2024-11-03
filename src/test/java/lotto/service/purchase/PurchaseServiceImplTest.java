package lotto.service.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.RandomNumbersSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseServiceImplTest {

    @DisplayName("구입할 금액이 가격보다 적으면 예외가 발생한다.")
    @Test
    void 구입할_금액이_가격보다_적으면_예외가_발생한다() throws Exception {
        PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();

        assertThatThrownBy(() -> purchaseService.purchase(900, new RandomNumbersSelector()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입할 로또가 1000개를 넘으면 예외가 발생한다")
    @Test
    void 구입할_로또가_1000개가_넘으면_예외가_발생한다() throws Exception {
        PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();

        assertThatThrownBy(() -> purchaseService.purchase(1_000_001, new RandomNumbersSelector()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 55555, 999999})
    void 구입할_금액이_로또금액과_맞아떨어지지_않으면_예외가_발생한다(int payAmount) throws Exception {
        PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
        assertThatThrownBy(() -> purchaseService.purchase(payAmount, new RandomNumbersSelector()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}