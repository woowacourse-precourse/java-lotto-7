package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.generator.SortedLottoNumberGenerator;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    @DisplayName("로또를 구매하고 로또의 개수를 확인한다.")
    void purchase() {
        //given
        LottoController lottoController = new LottoController(new LottoService(new SortedLottoNumberGenerator()));
        int money = 10000;

        //when
        List<Lotto> purchase = lottoController.purchase(money);

        //then
        assertThat(purchase.size()).isEqualTo(money/ LottoRule.LOTTO_PRICE.getValue());
    }
}