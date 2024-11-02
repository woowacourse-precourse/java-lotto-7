package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @Test
    void 로또_상점에서_로또를_구매한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoShop lottoShop = new LottoShop();
                    Lottos lottos = lottoShop.buy(4_000);
                    assertThat(lottos.getLottoCount()).isEqualTo(4);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(6, 7, 8, 9, 10, 11),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(18, 19, 20, 21, 22, 23)
        );
    }
}
