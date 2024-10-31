package lotto.domain.store;

import lotto.domain.entity.Lottos;
import lotto.domain.generate.RandomLottoNumberGenerator;
import lotto.domain.exception.PayException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    private final LottoStore lottoStore = new LottoStore(new RandomLottoNumberGenerator());

    @Test
    void 금액을_입력받고_로또_컬렉션_생성() {
        // given * when
        final Lottos lottos = lottoStore.issueLottos(14000);

        // then
        assertThat(lottos.lottos().size()).isEqualTo(14);
    }

    @Test
    void 금액이_1000원_미만이면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> {
            lottoStore.issueLottos(900);
        }).isInstanceOf(PayException.class);
    }

    @Test
    void 금액이_1000원단위로_나누어_떨어지지_않으면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> {
            lottoStore.issueLottos(13500);
        }).isInstanceOf(PayException.class);
    }
}