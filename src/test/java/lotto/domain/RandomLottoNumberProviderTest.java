package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberProviderTest {

	@DisplayName("로또 목록의 랜덤 번호들을 생성할 수 있다.")
	@Test
	void provideBy() {

		// given
		RandomLottoNumberProvider randomLottoNumberProvider = new RandomLottoNumberProvider();
		int purchaseLottoCount = 5;

		// when
		List<List<Integer>> randomLottoNumbers = randomLottoNumberProvider.provideBy(purchaseLottoCount);

		// then
		assertThat(randomLottoNumbers).hasSize(purchaseLottoCount)
			.allSatisfy(numbers ->
				assertThat(numbers).hasSize(6)
					.allMatch(number -> 0 <= number && number <= 45)
			);

	}
}