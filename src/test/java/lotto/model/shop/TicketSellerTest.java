package lotto.model.shop;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.message.LottoErrorMessage;
import lotto.model.ticket.LottoTickets;
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

        int purchaseAmount = LottoRule.PURCHASE_AMOUNT_UNIT.get();
        LottoTickets lottoTickets = ticketSeller.exchangeMoneyForTickets(purchaseAmount);
        assertEquals(lottoTickets.getCount(), 1);
    }

    @DisplayName("구입금액이 최소 구입금액보다 작은 경우 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenPurchaseAmountUnderBaseLimit() {
        LottoMachine lottoMachine = new LottoMachine();
        TicketSeller ticketSeller = new TicketSeller(lottoMachine);

        int purchaseAmount = LottoRule.PURCHASE_AMOUNT_UNIT.get() - 1;
        assertThatThrownBy(() -> ticketSeller.exchangeMoneyForTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.PURCHASE_AMOUNT_UNDER_BASE_LIMIT.get());
    }

    @DisplayName("구입금액의 단위가 올바르지 않은 경우 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenPurchaseAmountUnitIsInvalid() {
        LottoMachine lottoMachine = new LottoMachine();
        TicketSeller ticketSeller = new TicketSeller(lottoMachine);

        int purchaseAmount = LottoRule.PURCHASE_AMOUNT_UNIT.get() + 1;
        assertThatThrownBy(() -> ticketSeller.exchangeMoneyForTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.PURCHASE_AMOUNT_UNIT_INVALID.get());
    }
}
