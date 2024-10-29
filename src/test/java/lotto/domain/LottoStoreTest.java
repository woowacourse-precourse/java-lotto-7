package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    void buyLotto() {
    }

    @DisplayName("올바른 금액이 들어오면 로또가 정상 발급된다")
    @Test
    void 천원_이상_입력_시_로또_발행() {
        LottoStore lottoStore = new LottoStore();
        lottoStore.buyLotto(5000);
        List<Lotto> lottos = lottoStore.getLottos();

        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }


}