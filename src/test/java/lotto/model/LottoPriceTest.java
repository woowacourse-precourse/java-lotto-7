package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPriceTest {

    @Test
    void 로또_금액은_1000원_보다_작을_수_없다() {
        int price = -1000;

        assertThatThrownBy(() -> new LottoPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 가격은 1000원 이상이어야 합니다.");
    }

    @Test
    void 로또_금액은_1000원_단위여야_한다() {
        int price = 1234;

        assertThatThrownBy(() -> new LottoPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 가격은 1000원 단위여야 합니다.");
    }

    @Test
    void 로또_금액은_숫자여야_한다() {
        String price = "aa";

        assertThatThrownBy(() -> LottoPrice.valueOf(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 가격은 숫자여야 합니다.");
    }

}
