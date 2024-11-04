package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoCommitteeTest {

    @Test
    public void 로또번호가_당첨번호와_전부_일치하면_1등() {
        // given
        List<Integer> lottoNumbers = List.of(6, 2, 3, 4, 5, 1);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoCommittee committee = new LottoCommittee();
        committee.insertWinningNumbers(winningNumber);
        committee.insertBonusNumber(bonusNumber);

        // when
        Ranking ranking = committee.calculateRanking(lotto);

        // then
        Assertions.assertThat(ranking).isEqualTo(Ranking.FIRST_PLACE);
    }

    @Test
    public void 로또번호가_당첨번호와_5개_일치하고_보너스번호가_하나_일치하면_2등() {
        // given
        List<Integer> lottoNumbers = List.of(6, 2, 3, 4, 5, 1);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        LottoCommittee committee = new LottoCommittee();
        committee.insertWinningNumbers(winningNumber);
        committee.insertBonusNumber(bonusNumber);

        // when
        Ranking ranking = committee.calculateRanking(lotto);

        // then
        Assertions.assertThat(ranking).isEqualTo(Ranking.SECOND_PLACE);
    }

    @Test
    public void 로또번호가_당첨번호와_3개_일치하면_5등() {
        // given
        List<Integer> lottoNumbers = List.of(6, 2, 3, 4, 5, 1);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumber = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 6;
        LottoCommittee committee = new LottoCommittee();
        committee.insertWinningNumbers(winningNumber);
        committee.insertBonusNumber(bonusNumber);

        // when
        Ranking ranking = committee.calculateRanking(lotto);

        // then
        Assertions.assertThat(ranking).isEqualTo(Ranking.FIFTH_PLACE);
    }

    @Test
    public void 로또번호가_당첨번호와_2개_이하로_일치하면_낙첨() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumber = List.of(1, 2, 7, 8, 9, 10);
        int bonusNumber = 6;
        LottoCommittee committee = new LottoCommittee();
        committee.insertWinningNumbers(winningNumber);
        committee.insertBonusNumber(bonusNumber);

        // when
        Ranking ranking = committee.calculateRanking(lotto);

        // then
        Assertions.assertThat(ranking).isEqualTo(Ranking.LOSE);
    }
}
