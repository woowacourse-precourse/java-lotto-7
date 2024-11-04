package lotto.domain;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.enums.Rank;

class WinningLottoTest {

	@Test
	void 요쳥된_로또와_비교하여_당첨결과를_계산할_수_있다(){
		// given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);

		// when
		Optional<Rank> rank = winningLotto.calculateRank(lotto, bonusNumber);

		// then
		Assertions.assertThat(rank.get()).isEqualTo(Rank.FIRST);
	}

	@Test
	void 당첨번호가_5개이며_보너스번호가_일치할_경우_2등이다(){
		// given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);

		// when
		Optional<Rank> rank = winningLotto.calculateRank(lotto, bonusNumber);

		// then
		Assertions.assertThat(rank.get()).isEqualTo(Rank.SECOND);
	}

	@Test
	void 당첨번호가_5개이며_보너스번호가_일치하지_않는_경우_3등이다(){
		// given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(40);

		// when
		Optional<Rank> rank = winningLotto.calculateRank(lotto, bonusNumber);

		// then
		Assertions.assertThat(rank.get()).isEqualTo(Rank.THIRD);
	}
}