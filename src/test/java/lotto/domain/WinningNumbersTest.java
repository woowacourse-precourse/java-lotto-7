package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

	@DisplayName("당첨 번호를 생성할 수 있다.")
	@Test
	void of() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 31;

		// when
		WinningNumbers result = WinningNumbers.of(winningNumbers, bonusNumber);

		// then
		assertThat(result)
			.extracting("winningNumbers", "bonusNumber")
			.containsExactly(winningNumbers, bonusNumber);
	}

	@DisplayName("당첨 번호의 개수는 6개이여야한다.")
	@Test
	void ofWithOverFlowWinningNumbersSize() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
		int bonusNumber = 31;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호에 중복을 허용하지 않는다.")
	@Test
	void ofWithDuplicatedWinningNumbersSize() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
		int bonusNumber = 31;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 1미만의 숫자는 허용하지 않는다.")
	@Test
	void ofWithLessThanMinWinningNumber() {

		// given
		List<Integer> winningNumbers = List.of(0, 2, 3, 4, 5, 45);
		int bonusNumber = 31;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 45를 초과한 숫자는 허용하지 않는다.")
	@Test
	void ofWithGreaterThanMaxWinningNumber() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
		int bonusNumber = 31;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("보너스 번호는 1미만의 숫자는 허용하지 않는다.")
	@Test
	void ofWithLessThanMinBonusNumber() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
		int bonusNumber = 0;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("보너스 번호는 45를 초과한 숫자는 허용하지 않는다.")
	@Test
	void ofWithGreaterThanMaxBonusNumber() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
		int bonusNumber = 46;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호에 사용된 번호는 보너스 번호로 사용할 수 없다.")
	@Test
	void ofWithDuplicatedBonusNumberInWinningNumbers() {

		// given
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
		int bonusNumber = 1;

		// when // then
		assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호에 로또 번호가 포함되는지 확인할 수 있다.")
	@CsvSource({
		"1, true",
		"45, false"
	})
	@ParameterizedTest(name = "{0}의 포함 결과는 {1}이다")
	void doesWinningNumbersContains(int lottoNumber, boolean expect) {

		// given
		List<Integer> inputWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 31;
		WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers, bonusNumber);

		// when
		boolean result = winningNumbers.doesWinningNumbersContains(lottoNumber);

		// then
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName("보너스 번호가 로또 번호에 포함되는지 확인할 수 있다.")
	@CsvSource({
		"7, true",
		"45, false"
	})
	@ParameterizedTest(name = "{0}의 포함 결과는 {1}이다")
	void isBonusNumberContainedIn(int bonusNumber, boolean expect) {

		// given
		List<Integer> inputWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
		WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers, bonusNumber);

		List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

		// when
		boolean result = winningNumbers.isBonusNumberContainedIn(lottoNumbers);

		// then
		assertThat(result).isEqualTo(expect);
	}
}