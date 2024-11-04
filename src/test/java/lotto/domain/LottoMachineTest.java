package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구입 금액이 0보다 작거나 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void 구입_금액이_잘못된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 0보다 커야 합니다.");

        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1,000원 단위여야 합니다.");
    }
}