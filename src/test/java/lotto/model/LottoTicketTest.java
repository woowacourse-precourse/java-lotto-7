package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @ParameterizedTest
    @CsvSource({"1, 1", "100, 100", "123, 123"})
    void quantity_수량만큼_구매가_되어야한다(int quantity, int expected) {
        LottoTicket testLottoTicket = LottoTicket.purchase(quantity);
        assertThat(testLottoTicket.getLottoTicket().size()).isEqualTo(expected);
    }
}