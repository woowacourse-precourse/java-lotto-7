package lotto.service;

import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.LottoManager;
import lotto.formatter.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoServiceTest {
    private LottoValidator lottoValidator;
    private LottoNumbersGenerator lottoNumbersGenerator;
    private LottoManager lottoManager;
    private LottoFormatter lottoFormatter;
    private WinningLottoCounter winningLottoCounter;
    private WinningLottoCalculate winningLottoCalculate;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoValidator = new LottoValidator();
        lottoNumbersGenerator = new LottoNumbersGenerator(lottoValidator);
        lottoManager = new LottoManager(lottoNumbersGenerator);
        winningLottoCounter = new WinningLottoCounter();
        lottoFormatter = new LottoFormatter(winningLottoCounter);
        winningLottoCalculate = new WinningLottoCalculate(winningLottoCounter,lottoFormatter);
        lottoService = new LottoService(lottoManager, lottoFormatter, winningLottoCounter, winningLottoCalculate, lottoValidator);

        lottoService.callCreateLottos(6);
    }

    @Test
    void 로또_생성_호출_테스트() {
        int size = lottoService.formatBuyLottoNumbersResult().size();

        assertThat(size).isEqualTo(6);
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.getCalculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }

    @Test
    void 로또_수익률_계산_테스트() {
        lottoService.recordWinningLotto("1, 2, 3, 4, 5, 6", "7");
        int buyLottoMoney = 10000;

        double result = lottoService.callCalculateLottoRateOfReturn(buyLottoMoney);

        assertTrue(result >= 0, "로또 수익률이 0 이상인지 확인");
    }
}

