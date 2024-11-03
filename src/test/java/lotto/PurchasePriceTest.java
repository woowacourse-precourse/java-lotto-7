package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchasePrice(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
