package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 발행한_로또의_수량이_올바른지_테스트() {
        // given
        int purchaseAmount = 5000;
        int expected = purchaseAmount / 1000;

        // when
        int result = lottoService.calculateLottoQuantities(purchaseAmount);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 발행된_로또_번호의_범위_테스트() {
        List<Integer> result = lottoService.generateLottonumbers();
        assertThat(result.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
    }

    @Test
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        // given
        List<Integer> lottoNumber = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> result = lottoService.sortLottoNumbersAscending(lottoNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 로또의_번호들은_중복되지_않아야_한다() {
        Set<Integer> lottoNumbers = new HashSet<>(lottoService.generateLottonumbers());
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 발행된_로또들의_랭크_리스트를_올바르게_반환하는지_테스트() {
        // given
        List<Lotto> lottos = new ArrayList<>(List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,7))
        ));
        List<Integer> winningNubmers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        List<Rank> expected = new ArrayList<>(List.of(Rank.FIRST, Rank.SECOND));

        // when
        List<Rank> result = lottoService.getRanks(lottos, winningNubmers, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 로또_번호의_당첨_번호_일치_개수_테스트() {
        // given
        List<Rank> ranks = new ArrayList<>(List.of(Rank.FIRST, Rank.SECOND));
        Map<Rank, Integer> expected = new HashMap<>();
        expected.put(Rank.FIRST, 1);
        expected.put(Rank.SECOND, 1);
        expected.put(Rank.THIRD, 0);
        expected.put(Rank.FOURTH, 0);
        expected.put(Rank.FIFTH, 0);
        expected.put(Rank.NONE, 0);

        // when
        Map<Rank, Integer> result = lottoService.matchingWinningNumbers(ranks);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 수익률_계산이_올바른지_테스트() {
        // given
        List<Rank> ranks = new ArrayList<>(List.of(
                Rank.FIRST,
                Rank.SECOND,
                Rank.THIRD,
                Rank.NONE
        ));
        int purchaseAmount = 5000;
        double expected = (Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize()) / purchaseAmount * 100;

        // when
        double result = lottoService.calculateReturn(ranks, purchaseAmount);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
