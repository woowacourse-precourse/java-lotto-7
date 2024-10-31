package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();
    private static final List<Integer> WINNING_PRIZES = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);

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
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        List<Lotto> lottos = new ArrayList<>(List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 6개 일치
                new Lotto(List.of(1,2,3,4,5,7)), // 5개 일치 + 보너스 볼 일치
                new Lotto(List.of(1,2,3,4,5,8)) // 5개 일치
        ));
        int expected = WINNING_PRIZES.get(6) + WINNING_PRIZES.get(7) + WINNING_PRIZES.get(5);

        // when
        int result = lottoService.sumOfPrizes(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
