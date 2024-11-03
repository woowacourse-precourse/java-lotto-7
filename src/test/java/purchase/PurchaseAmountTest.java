package purchase;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class PurchaseAmountTest {

    @Test
    void 구매금액_유효성_검증_성공() {
        assertThatNoException().isThrownBy(() -> new PurchaseAmount(1000));
        assertThatNoException().isThrownBy(() -> new PurchaseAmount(14000));
    }

    @Test
    void 구매금액_유효성_검증_실패() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구매금액으로_발행할_로또_수량_계산() {
        PurchaseAmount amount = new PurchaseAmount(8000);
        assertThat(amount.calculateLottoCount()).isEqualTo(8);
    }
}