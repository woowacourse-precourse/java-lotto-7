package lotto.model.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 기계 객체 테스트")
class LottoMachineTest {

    @DisplayName("구매 단위가 올바른 경우 로또를 구매할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100})
    void shouldReturnLottoTickets_WhenPurchaseAmountUnitIsValid(int quantity) {
        LottoMachine lottoMachine = new LottoMachine();

        LottoTickets lottoTickets = lottoMachine.issueTicket(quantity);
        assertEquals(lottoTickets.getCount(), quantity);
    }
}
