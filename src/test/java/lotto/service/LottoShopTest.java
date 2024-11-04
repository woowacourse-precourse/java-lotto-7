package lotto.service;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoShopTest {

    @Test
    void 로또_구매_테스트() {
        //GIVEN
        int money = 6000;
        LottoShop lottoShop = new LottoShop();

        //WHEN
        List<Lotto> lottos = lottoShop.purchaseLotto(money);

        //THEN
        Assertions.assertThat(lottos.size()).isEqualTo(6);
    }

}
