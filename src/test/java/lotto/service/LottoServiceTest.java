package lotto.service;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoGenerator;
import lotto.domain.Lotto.LottoManager;
import lotto.domain.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoManager;
import lotto.dto.WinningLottoResultDTO;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 로또_생성_및_저장_확인() {
        int buyLottoCount = 3;
        lottoService.createLottos(buyLottoCount);

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

    @Test
    void 당첨_로또_결과_포맷_확인() {
        winningLottoManager.recordWinningLotto(6, false);
        winningLottoManager.recordWinningLotto(6, false);

        List<WinningLottoResultDTO> resultDTOs = lottoService.formatWinningLottoResults();

        assertThat(resultDTOs).isNotEmpty();

        for (WinningLottoResultDTO dto : resultDTOs) {
            if (dto.getMatchedCount() == 6) {
                assertThat(dto.getCount()).isEqualTo(2);
                assertThat(dto.getPrize()).isEqualTo(2000000000);
            } else {
                assertThat(dto.getCount()).isEqualTo(0);
            }
        }
    }
}
