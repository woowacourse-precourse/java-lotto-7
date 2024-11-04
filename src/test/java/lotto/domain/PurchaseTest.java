package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.purchase.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @Test
    @DisplayName("1,000 단위가 아닌 입력 금액 테스트")
    void 입력_금액이_1000원_단위가_아닌_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Purchase(8999))
                .withMessage("[ERROR] 입력 금액은 1,000원 단위만 가능합니다.");
    }

    @Test
    @DisplayName("1,000원 미만의 입력 테스트")
    void 입력_금액이_1000원_미만인_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Purchase(0))
                .withMessage("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Purchase(-1000))
                .withMessage("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Purchase(999))
                .withMessage("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다.");
    }

    @Test
    @DisplayName("100,000원 초과의 입력 테스트")
    void 입력_금액이_100000원_초과인_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Purchase(100001))
                .withMessage("[ERROR] 100,000원까지만 구매가 가능합니다.");
    }
}