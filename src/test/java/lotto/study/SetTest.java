package lotto.study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	@Test
	@DisplayName("Set의 크기 확인")
	void set_크기_확인() {
		Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("Set에 값이 존재하는지 확인")
	@ValueSource(ints = {1, 2, 3})
	void set에_값_존재하는지_확인(int input) {
		Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("Set에 값이 존재하지 않는 경우 확인")
	@CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
	void set_값_존재하지않는지_확인(int input, boolean expected) {
		Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
