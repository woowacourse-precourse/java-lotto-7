package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 숫자의 개수를 반환한다.")
	@Test
	void getWinningNumbersCountTest() {
		Set<Integer> winningNumbers = new TreeSet<>(List.of(1, 2, 3, 11, 22, 33));
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		assertThat(lotto.getWinningNumbersCount(winningNumbers)).isEqualTo(3);
	}

	@DisplayName("보너스 숫자가 있으면 True를 반환한다.")
	@Test
	void hasBonusNumberTest() {
		int bonusNumber = 1;
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		assertThat(lotto.hasBonusNumber(bonusNumber)).isTrue();
	}
}
