package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("천원_단위가_아니면_예외처리")
    void 천원_단위가_아니면_예외처리() {
        //GIVEN
        int money = 5500;
        LottoShop lottoShop = new LottoShop();
        //WHEN

        //THEN
        assertThrows(IllegalArgumentException.class, () ->
                lottoShop.purchaseLotto(money));
    }
}
