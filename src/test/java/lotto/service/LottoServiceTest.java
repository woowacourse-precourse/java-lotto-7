package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private static LottoService lottoService;

    @BeforeAll
    static void init() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void initLotto(int payCount) {
        // given
        
        // when
        List<Lotto> lottos = lottoService.initLotto(payCount);
        List<Lotto> distintLottos = lottos.stream().distinct().toList();

        // then
        assertThat(lottos).isEqualTo(distintLottos);
    }
}