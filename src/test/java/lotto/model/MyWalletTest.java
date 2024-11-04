package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyWalletTest {

    private MyWallet myWallet;

    @BeforeEach
    void setUp() {
        myWallet = new MyWallet();
    }

    @DisplayName("초기 상태에서 금액은 0이다.")
    @Test
    void 초기_상태에서_금액은_0이다() {
        assertThat(myWallet.getMoney()).isEqualTo(0);
    }

    @DisplayName("금액을 저장할 수 있다.")
    @Test
    void 금액을_저장할_수_있다() {
        myWallet.saveMoney(10000);
        assertThat(myWallet.getMoney()).isEqualTo(10000);
    }

    @DisplayName("로또를 구매하고 로또 목록에 추가된다.")
    @Test
    void 로또를_구매하고_로또목록에_추가된다() {
        myWallet.saveMoney(5000);
        myWallet.buyLottos();

        List<Lotto> lottos = myWallet.getLottos();
        assertThat(lottos).isNotEmpty();
    }

    @DisplayName("수익을 저장할 수 있다.")
    @Test
    void 수익을_저장할_수_있다() {
        myWallet.saveWinnings(15000);
        assertThat(myWallet.getWinnings()).isEqualTo(15000);
    }

    @DisplayName("로또 구매 후 로또 목록이 정확한 수량을 가진다.")
    @Test
    void 로또구매후_로또목록이_정확한_수량을_가진다() {
        myWallet.saveMoney(3000);
        myWallet.buyLottos();

        List<Lotto> lottos = myWallet.getLottos();
        assertThat(lottos).hasSize(3);
    }
}
