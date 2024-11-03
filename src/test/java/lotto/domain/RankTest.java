package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
	@Test
	@DisplayName("6개 일치시 1등이 반환한다.")
	void firstRank() {
		//given
		int inputMatchCount = 6;
		boolean inputMatchBonus = false;
		Rank expectRank = Rank.FIRST;

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isPresent();
		assertThat(rank.get()).isEqualTo(expectRank);
	}

	@Test
	@DisplayName("5개 일치, 보너스 볼 일치시 2등이 반환한다.")
	void secondRank() {
		//given
		int inputMatchCount = 5;
		boolean inputMatchBonus = true;
		Rank expectRank = Rank.SECOND;

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isPresent();
		assertThat(rank.get()).isEqualTo(expectRank);
	}

	@Test
	@DisplayName("5개 일치, 보너스 볼 불일치시 3등이 반환한다.")
	void thirdRank() {
		//given
		int inputMatchCount = 5;
		boolean inputMatchBonus = false;
		Rank expectRank = Rank.THIRD;

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isPresent();
		assertThat(rank.get()).isEqualTo(expectRank);
	}

	@Test
	@DisplayName("4개 일치시 4등이 반환한다.")
	void forthRank() {
		//given
		int inputMatchCount = 4;
		boolean inputMatchBonus = false;
		Rank expectRank = Rank.FORTH;

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isPresent();
		assertThat(rank.get()).isEqualTo(expectRank);
	}

	@Test
	@DisplayName("3개 일치시 5등이 반환한다.")
	void fifthRank() {
		//given
		int inputMatchCount = 3;
		boolean inputMatchBonus = false;
		Rank expectRank = Rank.FIFTH;

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isPresent();
		assertThat(rank.get()).isEqualTo(expectRank);
	}

	@DisplayName("일치하는 번호가 2개 이하일시 Optional.empty()를 반환한다.")
	@MethodSource("noRankProvider")
	@ParameterizedTest
	void noRank(int inputMatchCount, boolean inputMatchBonus) {
		//given

		//when
		Optional<Rank> rank = Rank.of(inputMatchCount, inputMatchBonus);

		//then
		assertThat(rank).isEmpty();
	}

	@Test
	@DisplayName("모든 랭크를 반환한다.")
	void allRanks() {
		//given
		List<Rank> expect = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FORTH, Rank.FIFTH);

		//when
		List<Rank> ranks = Rank.getRanks();

		//then
		assertThat(ranks).containsExactlyElementsOf(expect);
	}

	static Stream<Arguments> noRankProvider() {
		return Stream.of(
			Arguments.of(2, false),
			Arguments.of(1, false),
			Arguments.of(0, false)
		);
	}
}
