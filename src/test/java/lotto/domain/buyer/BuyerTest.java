package lotto.domain.buyer;

import static lotto.resources.Constants.THOUSAND_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
    Lotto customLotto1;
    Lotto customLotto2;
    Lotto customLotto3;
    BuyLottos customLottos;
    Buyer testBuyer;

    @BeforeEach
    void setUp() {
        customLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        customLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        customLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));

        customLottos = BuyLottos.of(Arrays.asList(customLotto1, customLotto2, customLotto3));

        testBuyer = BuyerFactory.createTestBuyer(3 * THOUSAND_UNIT, customLottos);
    }

    @DisplayName("구매한 로또 개수와 Lottos 객체가 동일하면 equals 하다.")
    @Test
    void 구매한_로또_개수와_Lottos_객체가_동일하면_equals_하다() {
        Lotto cloneCustomLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto cloneCustomLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto cloneCustomLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));
        BuyLottos cloneCustomLottos = BuyLottos.of(
                Arrays.asList(cloneCustomLotto1, cloneCustomLotto2, cloneCustomLotto3));

        Buyer cloneTestBuyer = BuyerFactory.createTestBuyer(3 * THOUSAND_UNIT, cloneCustomLottos);

        assertThat(testBuyer).isEqualTo(cloneTestBuyer);
    }

    @DisplayName("Lottos 객체 내 Lotto 순서가 다르면 equals 하지 않다.")
    @Test
    void Lottos_객체_내_Lotto_순서가_달라도_equals_하다() {
        Lotto cloneCustomLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto cloneCustomLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto cloneCustomLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));
        BuyLottos cloneCustomLottos = BuyLottos.of(
                Arrays.asList(cloneCustomLotto3, cloneCustomLotto2, cloneCustomLotto1));

        Buyer cloneTestBuyer = BuyerFactory.createTestBuyer(3 * THOUSAND_UNIT, cloneCustomLottos);

        assertThat(testBuyer).isNotEqualTo(cloneTestBuyer);

    }
}
