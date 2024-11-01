package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();
    private static final List<Integer> WINNING_PRIZES = List.of(0, 0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

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
    void 로또_번호의_당첨_번호_일치_개수_테스트() {
        // given
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        int expected = 3;

        // when
        int result = lottoService.matchingWinningNumbers(lottoNumbers, winningNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 로또_당첨금_총합_계산이_올바른지_테스트() {
        // given
        List<Rank> ranks = new ArrayList<>(List.of(
                Rank.FIRST,
                Rank.SECOND,
                Rank.THIRD,
                Rank.NONE
        ));
        int expected = Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize();

        // when
        int result = lottoService.sumOfPrizes(ranks);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 로또_당첨금_수익률_계산이_올바른지_태스트() {
        // given
        int sum = WINNING_PRIZES.get(5) + WINNING_PRIZES.get(6) + WINNING_PRIZES.get(7);
        int purchaseAmount = 3000;
        double expected = sum / purchaseAmount * 100;

        // when
        double result = lottoService.calculateReturn(sum, purchaseAmount);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
