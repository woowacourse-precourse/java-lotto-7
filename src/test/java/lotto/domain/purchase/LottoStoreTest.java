package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.purchase.LottoStore;
import lotto.utils.Constants;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {
    private LottoStore lottoStore;
    private final int ticketPrice = Constants.LOTTO_PRICE;

    @BeforeEach
    void setUp() {
        LottoGenerator mockLottoGenerator = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoStore = new LottoStore(ticketPrice, mockLottoGenerator);
    }

    @Test
    void 정상_금액으로_로또_티켓을_구입하면_티켓이_생성된다() {
        int amount = ticketPrice * 5;
        List<Lotto> tickets = lottoStore.purchaseLottoTickets(amount);

        assertThat(tickets).hasSize(5);
        assertThat(tickets).allSatisfy(ticket ->
                assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void 금액이_양수가_아닐_경우_예외가_발생한다(int invalidAmount) {
        assertThatThrownBy(() -> lottoStore.purchaseLottoTickets(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_POSITIVE_PURCHASE_AMOUNT);
    }

    @Test
    void 금액이_로또_가격의_배수가_아닐_경우_예외가_발생한다() {
        int invalidAmount = ticketPrice + 500;

        assertThatThrownBy(() -> lottoStore.purchaseLottoTickets(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_MULTIPLE_OF_PRICE);
    }
}
