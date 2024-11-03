package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구입_개수_테스트() {
        int purchaseAmount = 8000;

        assertThat(lottoService.getPurchaseCount(purchaseAmount))
                .isEqualTo(8);
    }

    @Test
    void 구입한_개수만큼_로또_번호_발행() {
        int purchaseCount = 8;
        List<Lotto> lottos = lottoService.makeLottos(purchaseCount);

        assertThat(lottos.size()).isEqualTo(purchaseCount);
    }

}
