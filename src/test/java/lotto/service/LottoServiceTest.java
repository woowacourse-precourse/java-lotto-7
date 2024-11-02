package lotto.service;

import lotto.domain.Lotto.LottoGenerator;
import lotto.domain.Lotto.LottoManager;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoManager;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoValidator lottoValidator;
    private LottoGenerator lottoGenerator;
    private LottoManager lottoManager;
    private LottoFormatter lottoFormatter;
    private WinningLottoManager winningLottoManager;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoValidator = new LottoValidator();
        lottoManager = new LottoManager();
        lottoFormatter = new LottoFormatter();
        lottoGenerator = new LottoGenerator(lottoValidator);
        winningLottoManager = new WinningLottoManager();
        lottoService = new LottoService(lottoGenerator, lottoManager, lottoFormatter, winningLottoManager);
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.calculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }
}
