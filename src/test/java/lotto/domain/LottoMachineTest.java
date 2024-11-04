package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구입 금액이 0보다 작거나 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_잘못된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 0보다 커야 합니다.");

        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("구입 금액에 따라 로또 티켓이 생성된다. - 1000원당 1개의 티켓 생성")
    @Test
    void 구입_금액에_따라_티켓이_생성된다() {
        int purchaseAmount = 3000;
        List<Lotto> tickets = lottoMachine.generateTickets(purchaseAmount);

        assertThat(tickets).hasSize(3);
    }
}