package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void init(){
        lottoService = new LottoService();
    }

    @DisplayName("로또 구매 금액에 따라 구매개수가 정해집니다")
    @ParameterizedTest
    @ValueSource(ints = {3000, 50000, 20000, 8000})
    void 로또_구매_개수(int amount){
        List<Lotto> lottos = lottoService.getLottos(amount);
        assertThat(lottos.size()).isEqualTo(amount/1000);
    }

    @DisplayName("구매된 로또들은 각각 하나의 Lotto객체로서 생성됩니다")
    @Test
    void 로또_생성(){
        int amount = 5000;
        List<Lotto> lottos = lottoService.getLottos(amount);
        for (Lotto lotto: lottos){
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
    }
}