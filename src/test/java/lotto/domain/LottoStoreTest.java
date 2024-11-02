package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }


    @Test
    void 올바른_금액으로_로또를_구매한다() {
        Lottos lottos = lottoStore.sell(5000);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void 천원_단위가_아닌_금액으로_구매시_예외가_발생한다() {
        assertThatThrownBy(() -> lottoStore.sell(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 최소_구매_금액보다_작은_금액으로_구매시_예외가_발생한다() {
        assertThatThrownBy(() -> lottoStore.sell(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @RepeatedTest(1000)
    void 구매한_로또의_번호에_중복은_없다() {
        Lottos lottos = lottoStore.sell(1000);
        List<Integer> numbers = lottos.getLottos().get(0).getNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }
}
