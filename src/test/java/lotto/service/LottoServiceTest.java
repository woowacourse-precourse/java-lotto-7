package lotto.service;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구매 금액 입력 후 로또 티켓 생성 테스트")
    void createLottoTicketTest() {
        String purchaseMoney = "5000";

        LottoTicket lottoTicket = lottoService.createLottoTicket(purchaseMoney);

        assertThat(lottoTicket.getLottosCount()).isEqualTo(5);
    }
}
