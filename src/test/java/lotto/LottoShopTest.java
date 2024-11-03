package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    LottoShop lottoShop = new LottoShop();

    @Test
    void setItem_getPrice() {
        lottoShop.setItem(Lotto.class, 1000);
        assertThat(lottoShop.getPrice(Lotto.class)).isEqualTo(1000);
    }

    @Test
    void buy() {
        List<Lotto> items = lottoShop.buy(Lotto.class, 8000);
        assertThat(items.size()).isEqualTo(8);
        assertThat(items).allMatch(Objects::nonNull);
    }
}