package ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.ticket.LottoIssuer;
import lotto.ticket.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @Test
    @DisplayName("로또 구입 금액이 0원이면 예외가 발생한다.")
    void validatePurchaseAmountIsNot0() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        int purchaseAmount = 0;
        assertThatThrownBy(() -> lottoIssuer.issue(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 0원보다 커야합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void validatePurchaseAmount() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        int purchaseAmount1 = 1200;
        int purchaseAmount2 = 900;
        assertThatThrownBy(() -> lottoIssuer.issue(purchaseAmount1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
        assertThatThrownBy(() -> lottoIssuer.issue(purchaseAmount2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
    }

    @Test
    @DisplayName("구입 금액을 1,000원 단위로 나눈 개수만큼 로또를 발급한다.")
    void issueLottoTickets() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        int purchaseAmount = 5000;
        List<Ticket> lottoTickets = lottoIssuer.issue(purchaseAmount);
        Assertions.assertThat(lottoTickets.size()).isEqualTo(5);
    }

}