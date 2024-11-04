package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {
    @Test
    void Lottos생성테스트() {
        // given
        Money money = new Money("8000");
        LottoShop lottoShop = new LottoShop();

        // when
        System.out.println("=====Logic Start=====");

        Lottos lottos = lottoShop.buyLottos(money);

        System.out.println("=====Logic End=====");
        // then
        assertThat(lottos.getBuyLottoQuantity()).isEqualTo(8);
    }
}