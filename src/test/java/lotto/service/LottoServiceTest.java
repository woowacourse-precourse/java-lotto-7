package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.LottoManager;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        lottoService = new LottoService(lottoManager, lottoFormatter, winningLottoCounter, winningLottoCalculate);

        lottoService.callCreateLottos(6);
    }

    @Test
    void 구매_로또_개수_계산() {
        int lottoCount = lottoService.getCalculateBuyLottoCount(5000);

        assertThat(lottoCount).isEqualTo(5);
    }

    @Test
    void 로또_생성_및_저장_확인() {
        int buyLottoCount = 3;
        lottoService.callCreateLottos(buyLottoCount);

        List<Lotto> createdLottos = lottoManager.getLottos();
        assertThat(createdLottos.size()).isEqualTo(buyLottoCount);

        for (Lotto lotto : createdLottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers.size()).isEqualTo(6);
            assertThat(numbers).doesNotHaveDuplicates();
            for (int number : numbers) {
                assertThat(number).isBetween(1, 45);
            }
        }
    }
}
