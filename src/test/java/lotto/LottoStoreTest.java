package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    @Test
    @DisplayName("금액이 1,000원 단위가 아닌 경우 예외가 발생한다")
    void 로또_구매_금액_단위_확인() {
        LottoStore lottoStore = new LottoStore();
        Integer invalidMoney = 1500;

        assertThatThrownBy(() -> lottoStore.sellLotto(invalidMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 금액을 입력했을 때 로또 티켓을 정상적으로 생성한다")
    void 로또_생성_확인() {
        LottoStore lottoStore = new LottoStore();
        Integer validMoney = 5000;

        List<Lotto> lottos = lottoStore.sellLotto(validMoney);

        assertThat(lottos).hasSize(5);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getIssuedLottoNumbers()).hasSize(6);
        }
    }
}
