package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = LottoService.getInstance();
    }

    @Test
    void 로또_구매_확인() {
        int price = 8000;

        List<Lotto> tickets = lottoService.purchaseLottoTickets(price);

        assertThat(8).isEqualTo(tickets.size());
    }

    @Test
    void 로또_당첨_확인() {
        List<Lotto> tickets = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> winCount = lottoService.checkWinning(tickets, winningNumbers, bonusNumber);

        assertThat(winCount.get(Rank.FIFTH_PLACE).intValue()).isEqualTo(0);
        assertThat(winCount.get(Rank.FOURTH_PLACE).intValue()).isEqualTo(0);
        assertThat(winCount.get(Rank.THIRD_PLACE).intValue()).isEqualTo(0);
        assertThat(winCount.get(Rank.SECOND_PLACE).intValue()).isEqualTo(0);
        assertThat(winCount.get(Rank.FIRST_PLACE).intValue()).isEqualTo(1);
    }
}
