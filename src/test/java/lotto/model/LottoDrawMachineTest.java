package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.Rank;
import org.junit.jupiter.api.Test;

class LottoDrawMachineTest {

    @Test
    void 로또_리스트와_당첨_번호를_비교한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        Map<Rank, Integer> rankResult = lottoResult.getRankCounts();

        // then
        assertThat(rankResult.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨번호와_일치하지_않으면_NONE으로_분류한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(11, 12, 13, 14, 15, 16);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        Map<Rank, Integer> rankResult = lottoResult.getRankCounts();

        // then
        assertThat(rankResult.containsKey(Rank.NONE)).isFalse();
        assertThat(rankResult.getOrDefault(Rank.FIRST, 0)).isEqualTo(0);
    }

    @Test
    void 발행한_로또가_1장이고_당첨_결과가_1등인_경우_수익률을_구한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        long winningSum = Rank.FIRST.price();
        long purchaseAmount = lottos.size() * 1000L;
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        double earningsRate = lottoResult.calculateEarningsRate(purchaseAmount);
        double result = (double) winningSum / purchaseAmount * 100;

        // then
        assertThat(earningsRate).isEqualTo(result);
    }

    @Test
    void 발행한_로또가_2장이고_당첨_결과가_1등_2등인_경우_수익률을_구한다() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        long winningSum = Rank.FIRST.price() + Rank.SECOND.price();
        long purchaseAmount = lottos.size() * 1000L;
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        double earningsRate = lottoResult.calculateEarningsRate(purchaseAmount);
        double result = (double) winningSum / purchaseAmount * 100;

        // then
        assertThat(earningsRate).isEqualTo(result);
    }

    @Test
    void 발행한_로또가_2장이고_일치하는_번호가_3개면_5등_당첨에_추가된다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(3, 14, 26, 36, 37, 44)),
                new Lotto(List.of(2, 4, 5, 19, 35, 38))
        );
        List<Integer> winningNumbers = List.of(3, 14, 26, 19, 35, 38);
        int bonus = 1;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        Map<Rank, Integer> rankResult = lottoResult.getRankCounts();

        // then
        assertThat(rankResult.get(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    void 발행한_로또가_1장이고_일치하는_번호가_3개인_경우_수익률을_계산한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 14, 15, 16);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        long winningSum = Rank.FIFTH.price();
        long purchaseAmount = lottos.size() * 1000L;
        LottoResult lottoResult = lottoDrawMachine.calculateLottoResult();
        double earningsRate = lottoResult.calculateEarningsRate(purchaseAmount);
        double result = (double) winningSum / purchaseAmount * 100;

        // then
        assertThat(earningsRate).isEqualTo(result);
    }


}