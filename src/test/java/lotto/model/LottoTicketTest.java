package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.service.LottoService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @ParameterizedTest
    @CsvSource({"1, 1", "100, 100", "123, 123"})
    void quantity_수량만큼_구매가_되어야한다(int quantity, int expected) {
        LottoService lottoService = new LottoService();
        LottoTicket testLottoTicket = lottoService.purchase(quantity);
        assertThat(testLottoTicket.getLottoTicket().size()).isEqualTo(expected);
    }
}