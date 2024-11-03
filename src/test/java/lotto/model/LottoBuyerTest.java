package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;
import lotto.factory.mock.MockLottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyerTest {

    @DisplayName("돈이 null일 경우 예외가 발생한다.")
    @Test
    void 돈이_null일_경우_예외가_발생한다() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        MockLottoMachine lottoMachine = new MockLottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoBuyer.buyLottoTickets(lottoMachine, null))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ErrorMessages.MONEY_NULL.getMessage());
    }

    @DisplayName("돈으로 로또 티켓을 구매하고 올바른 개수의 티켓이 생성된다.")
    @Test
    void 로또_티켓을_구매하고_정확한_개수의_티켓이_생성된다() {
        Money money = Money.of(10000);
        MockLottoMachine lottoMachine = new MockLottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoBuyer lottoBuyer = new LottoBuyer();
        LottoTickets tickets = lottoBuyer.buyLottoTickets(lottoMachine, money);

        assertThat(tickets.tickets()).hasSize(10);
    }
}
