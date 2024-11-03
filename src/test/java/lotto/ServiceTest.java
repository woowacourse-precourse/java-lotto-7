package lotto;

import java.util.Arrays;
import java.util.List;

import lotto.service.*;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {
    private static final List<Integer> LOTTO_FIRST = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> LOTTO_SECOND = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> LOTTO_THIRD = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> LOTTO_FOURTH = List.of(1, 2, 3, 4, 9, 10);
    private static final List<Integer> LOTTO_FIFTH = List.of(1, 2, 3, 11, 12, 13);
    private static final List<Integer> LOTTO_NOTHING = List.of(1, 2, 14, 15, 16, 17);

    @Test
    void 입력한_금액에_따라_로또_수량_출력() {
        int expectedTickets = 8;
        int actualTickets = TicketsService.purchaseTickets(8000);
        assertThat(actualTickets).isEqualTo(expectedTickets);
    }

    @Test
    void 로또_수량에_따라_로또_출력() {
        int tickets = 8;
        List<Lotto> actualLottos = LottosService.lottos(tickets);
        assertThat(actualLottos.size()).isEqualTo(tickets);
    }

    @Test
    void 발행한_로또의_등수_체크() {
        RankService rankService = new RankService();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(LOTTO_FIRST),
                new Lotto(LOTTO_SECOND),
                new Lotto(LOTTO_THIRD),
                new Lotto(LOTTO_FOURTH),
                new Lotto(LOTTO_FIFTH),
                new Lotto(LOTTO_NOTHING)
        );

        List<Integer> winnings = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7; // 보너스 번호

        rankService.checkRank(lottos, winnings, bonus);

        // 랭크별 구매 수량 검증
        assertThat(rankService.rankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(rankService.rankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(rankService.rankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(rankService.rankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankService.rankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankService.rankCount(Rank.NOTHING)).isEqualTo(1);
    }
}
