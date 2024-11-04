package lotto.domain.enums;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

	@Test
	void 당첨횟수가_3번_미만일_경우_빈_객체가_반환된다(){
		// given
		int winCount = 2;

		// when
		Optional<Rank> rank = Rank.judgeBy(winCount, true);

		// then
		Assertions.assertThat(rank).isEqualTo(Optional.empty());
	}

	@Test
	void 당첨횟수가_5번일때_보너스_번호가_일치할_경우_2등이다(){
		// given
		int winCount = 5;

		// when
		Optional<Rank> rank = Rank.judgeBy(winCount, true);

		// then
		Assertions.assertThat(rank.get()).isEqualTo(Rank.SECOND);
	}
}