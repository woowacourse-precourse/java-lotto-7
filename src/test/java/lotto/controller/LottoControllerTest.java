package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.TICKET_COUNT;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    private final LottoController lottoController = new LottoController(
            new InputView(), new PurchaseService(), new LottoService()
    );

    @Test
    @DisplayName("생성된 로또의 수가 제공한 로또의 수와 동일하다.")
    void equalLottosCountAndLottoTicketCount () {
        // given
        Integer lottoTicketCount = TICKET_COUNT;

        // when
        Lottos lottos = lottoController.generateLottos(lottoTicketCount);

        // then
        assertEquals(lottos.size(), lottoTicketCount);
    }
}