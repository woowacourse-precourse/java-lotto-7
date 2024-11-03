package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.RankService;
import lotto.service.RateService;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceRateTest {
    private static final List<Integer> LOTTO_FIRST = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> LOTTO_SECOND = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> LOTTO_THIRD = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> LOTTO_FOURTH = List.of(1, 2, 3, 4, 9, 10);
    private static final List<Integer> LOTTO_FIFTH = List.of(1, 2, 3, 11, 12, 13);
    private static final List<Integer> LOTTO_NOTHING = List.of(1, 2, 14, 15, 16, 17);

    private static final List<Lotto> LOTTO_LIST = Arrays.asList(
            new Lotto(LOTTO_FIRST),
            new Lotto(LOTTO_SECOND),
            new Lotto(LOTTO_THIRD),
            new Lotto(LOTTO_FOURTH),
            new Lotto(LOTTO_FIFTH),
            new Lotto(LOTTO_NOTHING)
    );

    private static final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;
    private static final int TICKET_COST = 1000;
    private static final int AMOUNT = 6 * TICKET_COST;

    @Test
    void 총당첨금액이_정확하게_계산된다() {
        RankService ranking = new RankService();
        ranking.checkRank(LOTTO_LIST, WINNING_NUMBERS, BONUS_NUMBER);
        int expectedTotalWinning = calculateExpectedTotalWinning(ranking);
        int actualTotalWinning = RateService.sumMoney(ranking);
        assertThat(actualTotalWinning).isEqualTo(expectedTotalWinning);
    }

    @Test
    void 수익률이_정확하게_계산된다() {
        RankService ranking = new RankService();
        ranking.checkRank(LOTTO_LIST, WINNING_NUMBERS, BONUS_NUMBER);
        double rate = RateService.calculateRate(ranking, AMOUNT);
        int expectedTotalWinning = calculateExpectedTotalWinning(ranking);
        assertThat(rate).isEqualTo(expectedTotalWinning / (double) AMOUNT * 100);
    }

    private int calculateExpectedTotalWinning(RankService rankService) {
        return Rank.FIRST.getRankMoney() * rankService.rankCount(Rank.FIRST) +
                Rank.SECOND.getRankMoney() * rankService.rankCount(Rank.SECOND) +
                Rank.THIRD.getRankMoney() * rankService.rankCount(Rank.THIRD) +
                Rank.FOURTH.getRankMoney() * rankService.rankCount(Rank.FOURTH) +
                Rank.FIFTH.getRankMoney() * rankService.rankCount(Rank.FIFTH) +
                Rank.NOTHING.getRankMoney() * rankService.rankCount(Rank.NOTHING);
    }
}
