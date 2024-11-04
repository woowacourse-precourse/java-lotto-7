package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.random.LottoRandom;

@DisplayName("로또 티켓들에 대해")
class LottosTest {

    private LottoRandom lottoRandom;

    @BeforeEach
    void setup() {
        lottoRandom = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100})
    void 주어진_개수에_맞게_구매하는가(int lottoCount) {
        Lottos boughtLottos = Lottos.buy(lottoRandom, lottoCount);
        assertThat(boughtLottos.size()).isEqualTo(lottoCount);
    }
}
