package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Guess;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {

    private LottoResultService lottoResultService;

    @BeforeEach
    void setUp() {
        lottoResultService = new LottoResultService();
    }

    @Test
    void 로또_1등_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsExactly(Rank.FIRST);
    }

    @Test
    void 로또_2등_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsExactly(Rank.SECOND);
    }

    @Test
    void 로또_3등_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsExactly(Rank.THIRD);
    }

    @Test
    void 로또_4등_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 44, 45)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsExactly(Rank.FOURTH);
    }

    @Test
    void 로또_5등_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 43, 44, 45)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsExactly(Rank.FIFTH);
    }

    @Test
    void 등수_없음_판별() {
        Guess guess = new Guess(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 42, 43, 44, 45))));
        lottos.add(new Lotto(List.of(1, 41, 42, 43, 44, 45)));
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45)));

        List<Rank> results = lottoResultService.determineRanks(guess, lottos);
        assertThat(results).containsOnly(Rank.NONE);
    }
}
