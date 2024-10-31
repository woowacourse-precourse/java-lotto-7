package lotto;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("구입_금액에_해당하는_만큼_로또를_발행한다")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        LottoShop lottoShop = new LottoShop();
        Long money = 8000L;

        // when
        List<List<Integer>> buyLottos = lottoShop.buyLottos(money);

        // then
        assertThat(buyLottos.size()).isEqualTo(8);
    }
}
