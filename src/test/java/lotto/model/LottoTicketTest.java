package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @DisplayName("LottoTicket을 생성할 수 있다.")
    @Test
    void LottoTicket_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Money price = Money.of(1000);
        LottoTicket ticket = new LottoTicket(lotto, price);

        assertThat(ticket).isNotNull();
        assertThat(ticket.lotto()).isEqualTo(lotto);
        assertThat(ticket.price()).isEqualTo(price);
    }

    @DisplayName("null Lotto를 입력할 경우 예외가 발생한다.")
    @Test
    void null_Lotto_예외() {
        Money price = Money.of(1000);

        assertThatThrownBy(() -> new LottoTicket(null, price))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessages.LOTTO_TICKETS_NULL.getMessage());
    }

    @DisplayName("null Price를 입력할 경우 예외가 발생한다.")
    @Test
    void null_Price_예외() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new LottoTicket(lotto, null))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessages.PRICE_NULL.getMessage());
    }

    @DisplayName("toString() 메소드가 로또 번호를 반환한다.")
    @Test
    void toString_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Money price = Money.of(1000);
        LottoTicket ticket = new LottoTicket(lotto, price);

        assertThat(ticket.toString()).isEqualTo(lotto.toString());
    }
}
