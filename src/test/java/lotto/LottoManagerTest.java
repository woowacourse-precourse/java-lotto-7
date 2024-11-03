package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.DTO.TryCountDTO;
import lotto.DTO.VictoryInfoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private LottoManager lottoManager;
    private TryCountDTO tryCountDTO;
    private VictoryInfoDTO victoryInfoDTO;

    @BeforeEach
    public void setUp() {
        tryCountDTO = new TryCountDTO(100000, 100000000);
        lottoManager = new LottoManager(tryCountDTO);
    }

    @Test
    @DisplayName("수익률 테스트")
    public void testRevenue() {
        victoryInfoDTO = new VictoryInfoDTO(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoManager.match(victoryInfoDTO);
        double revenue = lottoManager.revenue(tryCountDTO);
        assertTrue(revenue >= 0);
        System.out.println(revenue);
    }

    @Test
    @DisplayName("로또 티켓 생성 확인 테스트")
    public void getLottoTicketTest() {
        lottoManager = new LottoManager(tryCountDTO);
        assertNotNull(lottoManager.getLottoTicket());
        assertEquals(tryCountDTO.getTryCount(), lottoManager.getLottoTicket().size());
    }
}