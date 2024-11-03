package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import lotto.Lotto;
import lotto.model.InputAmount;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PickLottoTest {

    private TicketCount ticketCount;

    @BeforeEach
    public void GetThreeLottos() {
        // given
        InputAmount inputAmount = new InputAmount("3000");
        this.ticketCount = new TicketCount(inputAmount);
    }

    @DisplayName("로또 발매 시 입력받은 개수와 같은 개수의 로또가 발매된다.")
    @Test
    public void SameNumberOfTicketsWhenLotteryIssued() {
        // given
        PickLottoService pickLottoService = new PickLottoService();

        // when
        PurchasedLottos purchasedLottos = pickLottoService.auto(ticketCount);

        // then
        assertThat(purchasedLottos.get().size()).isEqualTo(3);
    }

    @DisplayName("발매된 로또는 각각 오름차순으로 정렬되어 있다.")
    @Test
    public void SortedAscendingWhenLotteryIssued() {
        // given
        PickLottoService pickLottoService = new PickLottoService();
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        PurchasedLottos purchasedLottos = pickLottoService.auto(ticketCount);

        // then
        for (Lotto nowTicket : purchasedLottos.get()) {
            List<Integer> lottoNums = nowTicket.get();
            assertThat(lottoNums).isSortedAccordingTo(comparator);
        }
    }

}
