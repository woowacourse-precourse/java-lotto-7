package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Amount;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또를 발행한다.")
    void issueLotto() {
        //given
        LottoCount lottoCount = LottoCount.from(Amount.of("10000"));

        //when
        Lottos lottos = lottoService.generateLottos(lottoCount);

        //then
        assertThat(lottos.getLottos()).hasSize(10);
    }
}