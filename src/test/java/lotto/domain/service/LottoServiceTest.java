package lotto.domain.service;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoStorage;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoGenerator lottoGenerator;
    private LottoStorage lottoStorage;
    private LottoService lottoService;



    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoStorage = new LottoStorage();
        lottoService = new LottoService(lottoGenerator, lottoStorage);
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.calculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }
}
