package lotto.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusTest {
	@Test
	@DisplayName("보너스 번호가 1에서 45 사이의 숫자이면 예외가 발생하지 않는다.")
	void should_NotThrowException_When_BonusNumberIsValid() {
		assertThatNoException().isThrownBy(() -> new LottoBonus(10, List.of(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("보너스 번호가 1 미만이면 예외가 발생한다.")
	void should_ThrowException_When_BonusNumberIsBelowRange() {
		assertThatThrownBy(() -> new LottoBonus(0, List.of(1, 2, 3, 0, 5, 6)))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
	}

	@Test
	@DisplayName("보너스 번호가 45 초과이면 예외가 발생한다.")
	void should_ThrowException_When_BonusNumberIsExceedRange() {
		assertThatThrownBy(() -> new LottoBonus(0, List.of(1, 2, 3, 4, 5, 46)))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
	}

	@Test
	@DisplayName("보너스 번호가 로또 번호와 중복되는 숫자라면 예외가 발생한다.")
	void should_ThrowException_When_BonusNumberIsDuplicateWithLottoNumbers() {
		assertThatThrownBy(() -> new LottoBonus(5, List.of(1, 2, 3, 4, 5, 6)))
				.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
	}
}
