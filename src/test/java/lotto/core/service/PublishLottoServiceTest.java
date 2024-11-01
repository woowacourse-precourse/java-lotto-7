package lotto.core.service;

import java.util.List;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PublishLottoServiceTest {

    private final PublishLottoService service = new PublishLottoService();

    @Test
    void publish_should_be_pass() {
        // given
        LottoPurchaseAmountDto amount = new LottoPurchaseAmountDto(100000, 10000);
        // when
        List<LottoDto> result = service.publish(amount);
        // then
        Assertions.assertEquals(10000, result.size());
        result.forEach((it) -> Assertions.assertEquals(6, it.numbers().size()));
    }
}
