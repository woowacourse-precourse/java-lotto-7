package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@DisplayName("로또 목록을 생성할 수 있다.")
	@Test
	void from() {

		// given
		List<List<Integer>> numbers = new ArrayList<>();
		List<Integer> numbers01 = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> numbers02 = List.of(1, 2, 11, 21, 31, 41);
		List<Integer> numbers03 = List.of(45, 44, 43, 42, 41, 40);
		numbers.add(numbers01);
		numbers.add(numbers02);
		numbers.add(numbers03);

		// when
		Lottos lottos = Lottos.from(numbers);

		// then
		assertThat(lottos.getLottos()).hasSize(3)
			.extracting("numbers")
			.containsExactly(
				numbers01,
				numbers02,
				numbers03
			);

	}
}