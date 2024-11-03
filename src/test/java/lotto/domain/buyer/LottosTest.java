package lotto.domain.buyer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    Lotto customLotto1;
    Lotto customLotto2;
    Lotto customLotto3;

    @BeforeEach
    void setUp() {
        customLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        customLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        customLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));
    }

    @DisplayName("Lottos 에 쌓은 순서가 동일하면 두 Lottos 객체는 equals 하다.")
    @Test
    void Lottos_에_쌓은_순서가_동일하면_두_Lottos_객체는_동일하다() {
        Lotto cloneCustomLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto cloneCustomLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto cloneCustomLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));

        Lottos lottos = LottosFactory.createCustomLottos(Arrays.asList(customLotto1, customLotto2, customLotto3));
        Lottos cloneLottos = LottosFactory.createCustomLottos(
                Arrays.asList(cloneCustomLotto1, cloneCustomLotto2, cloneCustomLotto3));

        assertThat(lottos).isEqualTo(cloneLottos);
    }

    @DisplayName("Lottos 내 쌓은 Lotto 순서가 다르면 두 객체는 equals 하지 않다.")
    @Test
    void Lottos내_쌓은_Lotto_순서가_다르면_두_객체는_equals_하지_않다() {
        Lotto cloneCustomLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto cloneCustomLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto cloneCustomLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));

        Lottos lottos = LottosFactory.createCustomLottos(Arrays.asList(customLotto1, customLotto2, customLotto3));
        Lottos cloneLottos = LottosFactory.createCustomLottos(
                Arrays.asList(cloneCustomLotto3, cloneCustomLotto2, cloneCustomLotto1));

        assertThat(lottos).isNotEqualTo(cloneLottos);
    }
}
