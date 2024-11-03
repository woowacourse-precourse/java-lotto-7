package lotto;

import static lotto.global.constant.Config.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @Test
    void 로또_구입_금액을_계산해_발행할_로또_생성() {
        //given
        LottoShop lottoShop = new LottoShop();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int price = 3 * LOTTO_PRICE;

        //when
        List<Lotto> lottos = lottoShop.buyLotto(price, () -> lotto);

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(price / LOTTO_PRICE);
    }

    @Test
    void 지정된_숫자_범위의_중복되지_않은_로또_번호_생성() {
        //given
        LottoShop lottoShop = new LottoShop();
        RandomLottoGenerator generator = new RandomLottoGenerator();
        int price = 3 * LOTTO_PRICE;

        //when
        List<Lotto> lottoSet = lottoShop.buyLotto(price, generator);

        //then
        Assertions.assertThat(lottoSet.size()).isEqualTo(price / LOTTO_PRICE);
    }
}