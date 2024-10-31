package lotto.service;


import lotto.Lotto;
import lotto.common.LottoConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    void 로또_서비스_테스트() {
        LottoService lottoService = new LottoService(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoService.getBonusWinningNumber()).isEqualTo(7);
        assertThat(lottoService.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 2000, 3000, 5000})
    void 로또_발행_테스트(int money) {
        LottoService lottoService = new LottoService(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoService.makeLottos(money);

        assertThat(lottoService.getLottos().size()).isEqualTo(money / LottoConstant.LOTTO_PRICE);
        assertThat(lottoService.getLottos()).allSatisfy(lotto -> {
            assertThat(lotto).isInstanceOf(Lotto.class);
        });
    }

}