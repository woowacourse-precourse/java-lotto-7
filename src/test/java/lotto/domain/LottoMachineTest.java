package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 발행 검증")
class LottoMachineTest {
    @Test
    @DisplayName("구입 개수만큼 로또가 발행되는지")
    void issueLottosByPurchaseQuantity() {
        assertThat(LottoMachine.create().issueLottos(3)).hasSize(3);
    }
}