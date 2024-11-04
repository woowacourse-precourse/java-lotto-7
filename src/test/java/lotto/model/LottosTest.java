package lotto.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static lotto.constant.LottoValue.LOTTO_PRICE;

import java.util.Arrays;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos();
    }

    @Test
    public void 로또가_정상적으로_생성되어_저장되는지_확인한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(7, 8, 9, 10, 11, 12);

        lottos.addLotto(numbers);

        assertThat(lottos.getLottos()).hasSize(1);
        assertThat(lottos.getLottos().get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottos.getLottos().size() * LOTTO_PRICE.getValue()).isEqualTo(LOTTO_PRICE.getValue());

        lottos.addLotto(numbers2);
        assertThat(lottos.getLottos()).hasSize(2);
        assertThat(lottos.getLottos().get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottos.getLottos().get(1).getLottoNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(lottos.getLottos().size() * LOTTO_PRICE.getValue()).isEqualTo(2 * LOTTO_PRICE.getValue());
    }
}
