package lotto.parser;

import static lotto.constant.Digit.*;
import static lotto.constant.ErrorMessage.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.List;

class ParserTest {
	private Parser parser;
	
	@BeforeEach
	void setUp() {
		parser = ParserImpl.getInstance();
	}
	
	@Test
	@DisplayName("구매 금액이 정상적으로 파싱")
	void purchaseAmount_validInput() {
		String input = "5000";
		BigInteger result = parser.purchaseAmount(input);
		assertThat(result).isEqualTo(BigInteger.valueOf(5000));
	}
	
	@Test
	@DisplayName("구매 금액 입력값이 숫자가 아니라면 예외 발생")
	void purchaseAmount_invalidInput_nonNumeric() {
		String input = "50ab00";
		assertThatThrownBy(() -> parser.purchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(IS_NOT_NUMBER);
	}
	
	@Test
	@DisplayName("구매 금액이 " + LOTTO_PRICE + "원 단위가 아니라면 예외 발생")
	void purchaseAmount_invalidInput_notMultipleOfThousand() {
		String input = "5500";
		
		assertThatThrownBy(() -> parser.purchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(IS_NOT_MULTIPLE_OF_THOUSAND);
	}
	
	@Test
	@DisplayName("당첨 번호가 정상적으로 파싱")
	void winningNumbers_validInput() {
		List<Integer> result = parser.winningNumbers("1,2,3,4,5,6");
		assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
	}
	
	@Test
	@DisplayName("당첨 번호 입력값이 쉼표로 구분되지 않는다면 예외 발생")
	void winningNumbers_invalidInput_missingSeparator() {
		assertThatThrownBy(() -> parser.winningNumbers("1 2 3 4 5 6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CANNOT_SPLIT_BY_SEPARATOR);
	}
	
	@Test
	@DisplayName("당첨 번호가 " + NUMBER_COUNT + "개가 아니라면 예외 발생")
	void winningNumbers_invalidInput_wrongCount() {
		assertThatThrownBy(() -> parser.winningNumbers("1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(INVALID_WINNING_NUMBERS_COUNT);
	}
	
	@Test
	@DisplayName("당첨 번호에 숫자가 아닌 값이 포함된다면 예외가 발생")
	void winningNumbers_invalidInput_nonNumeric() {
		assertThatThrownBy(() -> parser.winningNumbers("1,a,2,b,c,3"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(IS_NOT_NUMBER);
	}
	
	@Test
	@DisplayName("당첨 번호에 중복된 숫자가 있다면 예외 발생")
	void winningNumbers_invalidInput_duplicateNumber() {
		assertThatThrownBy(() -> parser.winningNumbers("1,2,3,4,5,5"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(DUPLICATED_NUMBERS);
	}
	
	@Test
	@DisplayName("보너스 번호가 정상적으로 파싱")
	void bonusNumber_validInput() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int result = parser.bonusNumber("7", winningNumbers);
		assertThat(result).isEqualTo(7);
	}
	
	@Test
	@DisplayName("보너스 번호가 숫자가 아니라면 예외 발생")
	void bonusNumber_invalidInput_nonNumeric() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> parser.bonusNumber("a", winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(IS_NOT_NUMBER);
	}
	
	@Test
	@DisplayName("보너스 번호가 " + START_NUMBER + " ~ " + END_NUMBER + "범위를 벗어난다면 예외 발생")
	void bonusNumber_invalidInput_outOfRange() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> parser.bonusNumber("50", winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(INVALID_RANGE);
	}
	
	@Test
	@DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외 발생")
	void bonusNumber_invalidInput_duplicatedWithWinningNumbers() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> parser.bonusNumber("3", winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER);
	}
}
