package lotto.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("지갑은")
class WalletTest {

    @Test
    void 금액이_로또_가격으로_나누어떨어지지_않으면_예외를_반환한다() {
        assertThatThrownBy(() -> new Wallet(3333))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈을_사용하면_최초_돈은_그대로이고_현재_돈만_줄어든다() {
        Wallet wallet = new Wallet(3000);
        wallet = wallet.useMoney(1000);
        assertThat(wallet.getInitialMoney()).isEqualTo(3000);
        assertThat(wallet.getMoney()).isEqualTo(2000);
    }
}
