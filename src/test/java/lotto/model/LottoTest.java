package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	@DisplayName("로또 번호가 6개이고 중복이 없으면 예외가 발생하지 않는다.")
	void should_NotThrowException_When_LottoNumberIsValid() {
		new Lotto(List.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	void should_ThrowException_When_LottoNumberCountExceedSix() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	void should_ThrowException_When_LottoNumbersContainDuplicates() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
	}
}
