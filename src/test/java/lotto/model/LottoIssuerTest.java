package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @Test
    @DisplayName("로또 구입 금액이 0원이면 예외가 발생한다.")
    void validatePurchaseAmountIsNot0() {
        LotteryIssuer lotteryIssuer = new LotteryIssuer();
        int purchaseAmount = 0;
        assertThatThrownBy(() -> lotteryIssuer.issue(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 0원보다 커야합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    void validateNegativePurchaseAmount() {
        LotteryIssuer lotteryIssuer = new LotteryIssuer();
        int purchaseAmount = -1000;
        assertThatThrownBy(() -> lotteryIssuer.issue(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 0원보다 커야합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void validatePurchaseAmount() {
        LotteryIssuer lotteryIssuer = new LotteryIssuer();
        int purchaseAmount1 = 1200;
        int purchaseAmount2 = 900;
        assertThatThrownBy(() -> lotteryIssuer.issue(purchaseAmount1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
        assertThatThrownBy(() -> lotteryIssuer.issue(purchaseAmount2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
    }

    @Test
    @DisplayName("구입 금액을 1,000원 단위로 나눈 개수만큼 로또를 발급한다.")
    void issueLottoTickets() {
        LotteryIssuer lotteryIssuer = new LotteryIssuer();
        int purchaseAmount = 5000;
        List<Ticket> lotteries = lotteryIssuer.issue(purchaseAmount);
        Assertions.assertThat(lotteries.size()).isEqualTo(5);
    }

}