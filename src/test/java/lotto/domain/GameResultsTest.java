package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.enums.Rank;

class GameResultsTest {

	@Test
	void 로또_목록의_당첨결과를_계산할_수_있다(){
		// given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
		Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
		Lotto lotto5 = new Lotto(List.of(1, 2, 3, 40, 35, 10));
		Lotto lotto6 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
		List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);

		// when
		GameResults gameResults = new GameResults(lottos, winningLotto, bonusNumber);

		// then
		assertThat(gameResults.getCountBy(Rank.FIRST)).isEqualTo(1);
		assertThat(gameResults.getCountBy(Rank.SECOND)).isEqualTo(1);
		assertThat(gameResults.getCountBy(Rank.THIRD)).isEqualTo(2);
		assertThat(gameResults.getCountBy(Rank.FIFTH)).isEqualTo(1);
	}
	@Test
	void 당첨되지_않은_로또는_횟수가_0이다(){
		// given
		Lotto lotto6 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
		List<Lotto> lottos = List.of(lotto6);

		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);

		// when
		GameResults gameResults = new GameResults(lottos, winningLotto, bonusNumber);

		// then
		assertThat(gameResults.getCountBy(Rank.FIRST)).isEqualTo(0);
		assertThat(gameResults.getCountBy(Rank.SECOND)).isEqualTo(0);
		assertThat(gameResults.getCountBy(Rank.THIRD)).isEqualTo(0);
		assertThat(gameResults.getCountBy(Rank.FOURTH)).isEqualTo(0);
		assertThat(gameResults.getCountBy(Rank.FIFTH)).isEqualTo(0);
	}

	@Test
	void 수익률을_계산할_수_있다(){
		// given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
		Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
		Lotto lotto5 = new Lotto(List.of(1, 2, 3, 40, 35, 10));
		Lotto lotto6 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
		List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);

		// when
		GameResults gameResults = new GameResults(lottos, winningLotto, bonusNumber);

		// then
		assertThat(gameResults.getRoundedProfitRate(lottos)).isEqualTo(33883416.67);
	}
}