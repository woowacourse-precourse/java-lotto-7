package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    @Test
    void 로또_한장당_천원에_구매할_수_있다() {
        LottoSeller seller = new LottoSeller();

        List<Lotto> lottos = seller.sell(6000);

        assertThat(lottos.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10, 1020})
    void 유효하지않은_금액(int price) {
        LottoSeller seller = new LottoSeller();

        assertThrows(IllegalArgumentException.class, () -> {
            seller.sell(price);
        });
    }
}