package lotto.model.ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.rule.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 판매원 객체 테스트")
class TicketSellerTest {

    @DisplayName("구매 단위가 올바른 경우 로또를 구매할 수 있다.")
    @Test
    void shouldReturnLottoTickets_WhenPurchaseAmountUnitIsValid() {
        LottoMachine lottoMachine = new LottoMachine();
        TicketSeller ticketSeller = new TicketSeller(lottoMachine);

        int purchaseAmount = LottoRule.PURCHASE_AMOUNT_UNIT;
        LottoTickets lottoTickets = ticketSeller.exchangeMoneyForTickets(purchaseAmount);
        assertEquals(lottoTickets.getCount(), 1);
    }

    @DisplayName("구매 단위가 올바르지 않은 경우 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenPurchaseAmountUnitIsInvalid() {
        LottoMachine lottoMachine = new LottoMachine();
        TicketSeller ticketSeller = new TicketSeller(lottoMachine);

        int purchaseAmount = LottoRule.PURCHASE_AMOUNT_UNIT + 1;
        assertThatThrownBy(() -> ticketSeller.exchangeMoneyForTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
