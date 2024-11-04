package lotto;

import static lotto.validation.LottoValidation.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoTest {

	private static final String INVALID_NUMBER_INPUT = "1000j";
	private static final String INVALID_AMOUNT_INPUT = "1500";
	private static final String INVALID_WINNING_NUMBERS = "1, 2, 3, 4, 5";
	private static final String INVALID_BONUS_NUMBER = "46";
	private static final String DUPLICATE_BONUS_NUMBER = "3";

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

	@Test
	@DisplayName("구입 금액이 1,000원 단위가 아닐 때 예외가 발생한다")
	void 구입_금액이_천원_단위가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> parseAmount("1500"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
	void 로또_번호가_6개가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> parseNumbers("1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("보너스 번호가 1~45 범위를 벗어날 때 예외가 발생한다")
	void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> parseBonusNumber("46", winningNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("보너스 번호가 로또 번호와 중복될 경우 예외가 발생한다")
	void 보너스_번호가_로또_번호와_중복될_경우_예외가_발생한다() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> parseBonusNumber("3", winningNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
