package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.domain.LottoResultFormatter;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoValidator lottoValidator;
    private LottoGenerator lottoGenerator;
    private LottoManager lottoManager;
    private LottoResultFormatter lottoResultFormatter;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoValidator = new LottoValidator();
        lottoManager = new LottoManager();
        lottoResultFormatter = new LottoResultFormatter();
        lottoGenerator = new LottoGenerator(lottoValidator);
        lottoService = new LottoService(lottoGenerator, lottoManager, lottoResultFormatter);
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.calculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }
}
