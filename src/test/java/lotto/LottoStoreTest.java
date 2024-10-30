package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    public void init() {
        lottoStore = new LottoStore();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "8000:8", "12000:12"}, delimiter = ':')
    @DisplayName("로또 구매")
    public void purchase(int money, int numOfLotto) {
        // when
        List<Lotto> lottos = lottoStore.purchase(money);

        // then
        assertThat(lottos.size())
                .isEqualTo(numOfLotto);
    }
}
