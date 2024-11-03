package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    final LottoService lottoService = new LottoService();

    @Test
    void 로또_구매_갯수만큼_로또를_생성한다() {
        // given
        int lottoQuantity = 3;

        // when
        Lottos lottos = lottoService.createLottos(lottoQuantity);

        int actual = lottos.getLottoGroup().size();

        // then
        assertThat(actual).isEqualTo(lottoQuantity);
    }
}
