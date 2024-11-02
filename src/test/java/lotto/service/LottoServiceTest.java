package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또를 발행한다.")
    void issueLotto() {
        //given
        Amount amount = Amount.of("10000");

        //when
        Lottos lottos = lottoService.issueLottos(amount);

        //then
        assertThat(lottos.getLottos()).hasSize(10);
        lottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isSorted()
        );
    }
}