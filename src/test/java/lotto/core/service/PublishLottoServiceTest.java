package lotto.core.service;

import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoTicketDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublishLottoServiceTest {

    private PublishLottoTicketService service;

    @BeforeEach
    void setUp() {
        service = new PublishLottoTicketService();
    }

    @Test
    void publish_should_be_pass() {
        // given
        LottoPurchaseAmountDto amount = new LottoPurchaseAmountDto(100000, 10000);
        // when
        LottoTicketDto ticket = service.publish(amount);
        // then
        Assertions.assertEquals(10000, ticket.lottos().size());
        ticket.lottos().forEach(it -> Assertions.assertEquals(6, it.numbers().size()));
    }
}
