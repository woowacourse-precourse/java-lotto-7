package lotto.domain.service;

import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;



    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.calculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }
}
