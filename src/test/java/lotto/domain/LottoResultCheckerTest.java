package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.utils.FixedNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultCheckerTest {
    private LotteryMachine lotteryMachine;
    private LottoRaffle lottoRaffle;
    List<Lotto> lottos = new ArrayList<>();
    private int BONUS_NUMBER;
    private LottoResultChecker lottoResultChecker;

    @BeforeEach
    void createWinningLotto() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        BONUS_NUMBER = 7;
        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(winningNumber));
        lottoRaffle = new LottoRaffle(lotteryMachine.createLottoTicket(), BONUS_NUMBER);
    }

    @BeforeEach
    void createLotto() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));
    }

    @Test
    void 로또번호가_당첨번호와같으면_개수를반환한다() {
        lottoResultChecker = new LottoResultChecker(lottoRaffle, lottos);
        int matchCount = lottoResultChecker.findMatchCount(lottos.getFirst());
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 당첨결과를_등수로_구분한다() {
        lottoResultChecker = new LottoResultChecker(lottoRaffle, lottos);

        Map<Rank, Integer> rank = lottoResultChecker.findRank();

        assertThat(rank.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rank.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rank.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rank.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rank.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rank.get(Rank.NONE)).isEqualTo(1);

    }
}