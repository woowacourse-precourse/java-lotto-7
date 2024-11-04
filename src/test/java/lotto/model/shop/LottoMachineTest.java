package lotto.model.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.message.LottoErrorMessage;
import lotto.model.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 기계 객체 테스트")
class LottoMachineTest {

    @DisplayName("구매 개수가 올바른 경우 로또를 구매할 수 있다.")
    @ParameterizedTest(name = "구매 개수: {0}")
    @ValueSource(ints = {1, 2, 100})
    void shouldReturnLottoTickets_WhenPurchaseAmountUnitIsValid(int quantity) {
        LottoMachine lottoMachine = new LottoMachine();

        LottoTickets lottoTickets = lottoMachine.issueTicket(quantity);
        assertEquals(lottoTickets.getCount(), quantity);
    }

    @DisplayName("1개보다 작은 로또를 발급할 경우 예외가 발생한다.")
    @ParameterizedTest(name = "구매 개수: {0}")
    @ValueSource(ints = {0, -1})
    void shouldThrowException_WhenPurchaseQuantityLessThan1(int quantity) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.issueTicket(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.MIN_QUANTITY_LOTTO_ISSUE.get());
    }
}
