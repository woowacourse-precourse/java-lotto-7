package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @Test
    void 로또_상점에서_로또를_구매한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoShop lottoShop = new LottoShop();
                    Lottos lottos = lottoShop.buy(4_000);
                    assertThat(lottos.size()).isEqualTo(4);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(6, 7, 8, 9, 10, 11),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(18, 19, 20, 21, 22, 23)
        );
    }
}
