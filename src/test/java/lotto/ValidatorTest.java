package lotto;

import org.junit.jupiter.api.Test;
import validator.PurchaseAmountValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 구입금액_올바르게_입력한_경우_정상_처리() {
        int amount = PurchaseAmountValidator.validate("3000");
        assertThat(amount).isEqualTo(3000);
    }

    @Test
    void 구입금액_1000원_단위가_아닐_경우_예외_발생() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate("3500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 구입금액이_숫자가_아닐_경우_예외_발생() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 숫자로 입력해 주세요");
    }

    @Test
    void 구입금액이_음수일_경우_예외_발생() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 음수가 아닌 양수여야 합니다.");
    }

    @Test
    void 구입금액이_0일_경우_예외_발생() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 0이 아닌 금액이어야 합니다.");
    }
}
