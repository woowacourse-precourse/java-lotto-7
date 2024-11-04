package lotto.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("지갑은")
class WalletTest {

    @ParameterizedTest
    @ValueSource(longs = {1, 33, 100, 1001, 9999})
    void 금액이_로또_가격으로_나누어떨어지지_않으면_예외를_반환한다(long money) {
        assertThatThrownBy(() -> new Wallet(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000, 1000, 2000",
        "2000, 1000, 1000",
        "10000, 10000, 0",
        "30000, 12000, 18000"
    })
    void 돈을_사용하면_최초_돈은_그대로이고_현재_돈만_줄어든다(long initialMoney, long spentMoney, long leftMoney) {
        Wallet wallet = new Wallet(initialMoney);
        wallet = wallet.useMoney(spentMoney);
        assertThat(wallet.getInitialMoney()).isEqualTo(initialMoney);
        assertThat(wallet.getMoney()).isEqualTo(leftMoney);
    }
}
