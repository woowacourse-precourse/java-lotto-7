package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Lotto;
import lotto.domain.LottoRepository;

class LottoServiceTest {
	private final LottoService lottoService = LottoService.getInstance();

	@DisplayName("입력된 당첨 번호를 저장한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16"})
	void saveWinningNumbersTest(String numbers) {
		assertThatCode(() -> lottoService.saveWinningNumbers(numbers))
			.doesNotThrowAnyException();
	}

	@DisplayName("입력된 보너스 번호를 저장한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void saveBonusNumberTest(String number) {
		assertThatCode(() -> lottoService.saveBonusNumber(number))
			.doesNotThrowAnyException();
	}

	@DisplayName("로또 번호는 1미만, 45초과할 경우 예외를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {"0", "46"})
	void validateNumberRangeTest(String number) {
		assertThatThrownBy(() -> lottoService.saveBonusNumber(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("로또 번호가 6개가 아닐경우 예외를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,5", "11,12,13,14,15,16,17"})
	void validateDuplicateNumbersTest(String number) {
		assertThatThrownBy(() -> lottoService.saveWinningNumbers(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("보너스 번호는 당첨 번호와 중복되면 예외를 던진다.")
	@Test
	void validateDuplicateNumbersTest() {
		lottoService.saveWinningNumbers("1,2,3,4,5,6");
		String bonusNumber = "1";

		assertThatThrownBy(() -> lottoService.saveBonusNumber(bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Nested
	@DisplayName("로또 구매 테스트")
	class BuyTest {
		private final LottoRepository lottoRepository = LottoRepository.getInstance();

		@AfterEach
		void tearDown() {
			lottoRepository.clear();
		}

		@DisplayName("로또 구매에 성공한다.")
		@ParameterizedTest
		@ValueSource(ints = {1000, 10000, 100000})
		void buyTest(int amount) {
			List<Lotto> lotto = lottoService.buy(amount);
			assertThat(lotto).hasSize(amount / 1000);
		}

		@DisplayName("로또 구매 금액이 1000단위가 아니면 예외를 던진다.")
		@ParameterizedTest
		@ValueSource(ints = {999, 1999})
		void validateAmountTest(int amount) {
			assertThatThrownBy(() -> lottoService.buy(amount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[ERROR]");
		}
	}
}