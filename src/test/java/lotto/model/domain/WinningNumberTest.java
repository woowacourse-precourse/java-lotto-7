package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
	@DisplayName("당첨 번호가 6개가 아니면 예외 발생")
	@Test
	void 당첨번호가_6개가_아닐경우() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
	}

	@DisplayName("당첨 번호가 1과 45 사이의 숫자가 아니면 예외 발생")
	@Test
	void 당첨번호가_1과_45_사이의_숫자가_아닐경우() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 50)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
	}

	@DisplayName("당첨 번호에 중복된 숫자가 있으면 예외 발생")
	@Test
	void 당첨번호에_중복된_숫자가_있을경우() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 4, 6)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
	}
}
