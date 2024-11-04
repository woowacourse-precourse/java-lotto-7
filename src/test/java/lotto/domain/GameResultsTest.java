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

		GameResults gameResults = new GameResults();

		// when
		gameResults.calculateGameResult(lottos, winningLotto, bonusNumber);

		// then
		assertThat(gameResults.getGameResultMap().get(Rank.FIRST)).isEqualTo(1);
		assertThat(gameResults.getGameResultMap().get(Rank.SECOND)).isEqualTo(1);
		assertThat(gameResults.getGameResultMap().get(Rank.THIRD)).isEqualTo(2);
		assertThat(gameResults.getGameResultMap().get(Rank.FIFTH)).isEqualTo(1);
	}
}