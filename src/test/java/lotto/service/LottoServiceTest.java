package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.service.LottoService;
import lotto.mock.FakeRandomHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService(new FakeRandomHolder(List.of(1,2,3,4,5,6)));

    @Test
    @DisplayName("1000원 단위로 구매하면 로또를 살 수 있다")
    void purchaseLotto() throws Exception {
        // given
        int amount = 2000;

        // when
        List<Lotto> lottos = lottoService.purchaseLottos(amount);

        // then
        assertThat(lottos).hasSize(2)
                .extracting("numbers")
                .containsExactlyInAnyOrder(List.of(1,2,3,4,5,6),
                        List.of(1,2,3,4,5,6));
    }

}