package lotto.service;

import static lotto.config.LottoRule.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.generator.SortedLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("로또를 구매하고 로또의 개수를 확인한다.")
    void purchase() {
        //given
        LottoService lottoService = new LottoService(new SortedLottoNumberGenerator());

        //when
        int money = 10000;
        List<Lotto> purchasedLotto = lottoService.purchase(money);

        //then
        assertThat(purchasedLotto.size()).isEqualTo(money / LOTTO_PRICE);
    }
}