package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.validator.LottoValidationMessage;

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

	@DisplayName("랜덤 번호를 받아 로또를 생성한다.")
	@Test
	void createLotto() {
		//given
		List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);

		//when
		Lotto winningNumbers = new Lotto(inputNumbers);

		//then
		assertThat(winningNumbers).isNotNull();
	}

	@DisplayName("랜덤 번호의 개수가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidSizeProvider")
	@ParameterizedTest
	void ofNotSize(List<Integer> inputNumbers) {
		//given

		//when & then
		assertThatThrownBy(() -> new Lotto(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(LottoValidationMessage.INVALID_LOTTO_NUMBERS_SIZE.getMessage());
	}

	@DisplayName("랜덤 번호의 숫자가 1~45 범위에 있지 않으면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidRangeProvider")
	@ParameterizedTest
	void ofNotInRange(List<Integer> inputNumbers) {
		//given

		//when & then
		assertThatThrownBy(() -> new Lotto(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(LottoValidationMessage.INVALID_LOTTO_NUMBERS_RANGE.getMessage());
	}

	@DisplayName("랜덤 번호의 숫자가 중복되었다면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidDuplicateProvider")
	@ParameterizedTest
	void ofDuplication(List<Integer> inputNumbers) {
		//given

		//when & then
		assertThatThrownBy(() -> new Lotto(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(LottoValidationMessage.INVALID_LOTTO_NUMBERS_DUPLICATION.getMessage());
	}

	@DisplayName("당첨 번호를 받아 일치하는 카운트를 반환한다.")
	@MethodSource("winningNumbersProvider")
	@ParameterizedTest
	void getMatchCount(List<Integer> inputWinningNumbers, int expectCount) {
		//given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		//when
		int result = lotto.getMatchCount(inputWinningNumbers);

		//then
		assertThat(result).isEqualTo(expectCount);
	}

	@DisplayName("보너스 번호를 받아 true / false를 반환한다.")
	@MethodSource("bonusNumberProvider")
	@ParameterizedTest
	void getMatchBonus(int inputBonusNumber, boolean expect) {
		//given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		//when
		boolean result = lotto.getMatchBonus(inputBonusNumber);

		//then
		assertThat(result).isEqualTo(expect);
	}

	static Stream<List<Integer>> invalidSizeProvider() {
		return Stream.of(
			List.of(1, 2, 3, 4, 5),
			List.of(1, 2, 3, 4, 5, 6, 7)
		);
	}

	static Stream<List<Integer>> invalidRangeProvider() {
		return Stream.of(
			List.of(-1, 0, 1, 2, 3, 4),
			List.of(46, 47, 48, 49, 50, 51),
			List.of(-1, 1, 2, 3, 4, -5)
		);
	}

	static Stream<List<Integer>> invalidDuplicateProvider() {
		return Stream.of(
			List.of(1, 1, 1, 1, 1, 1),
			List.of(1, 2, 3, 4, 4, 5),
			List.of(1, 1, 2, 3, 4, 3)
		);
	}

	static Stream<Arguments> winningNumbersProvider() {
		return Stream.of(
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
			Arguments.of(List.of(2, 3, 4, 5, 6, 7), 5),
			Arguments.of(List.of(1, 11, 12, 13, 4, 5), 3)
		);
	}

	static Stream<Arguments> bonusNumberProvider() {
		return Stream.of(
			Arguments.of(1, true),
			Arguments.of(7, false),
			Arguments.of(13, false)
		);
	}
}
