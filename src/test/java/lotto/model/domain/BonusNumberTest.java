package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
	@DisplayName("보너스 번호가 1과 45 사이의 숫자가 아니면 예외 발생")
	@Test
	void 보너스번호가_1과_45_사이의_숫자가_아닐경우() {
		assertThatThrownBy(() -> new BonusNumber(List.of(1, 2, 3, 4, 5, 50), 5))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
	}

	@DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
	@Test
	void 보너스번호가_당첨번호와_중복될_경우() {
		assertThatThrownBy(() -> new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 5))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
	}
}
