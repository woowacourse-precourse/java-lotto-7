package lotto.service;

import lotto.calculation.LottoTicketManager;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoGenerator.END_INCLUSIVE;
import static lotto.domain.LottoGenerator.START_INCLUSIVE;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoGenerator lottoGenerator;
    private LottoTicketManager lottoTicketManager;
    private LottoService lottoService;
    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoTicketManager = new LottoTicketManager();
        lottoService = new LottoService(lottoGenerator, lottoTicketManager);
    }

    @Test
    void 로또_5장_생성() {
        int amount = 5000;
        int expectedTicketCount = 5;

        List<Lotto> actualLottos = lottoService.generateLottos(amount);

        assertEquals(expectedTicketCount, actualLottos.size());
        for (Lotto lotto : actualLottos) {
            assertEquals(6, lotto.getNumbers().size());
            assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= START_INCLUSIVE  && num <= END_INCLUSIVE));
        }
    }
}