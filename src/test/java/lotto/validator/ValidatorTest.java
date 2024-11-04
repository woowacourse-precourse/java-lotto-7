package lotto.validator;

import static lotto.constant.Digit.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Regex.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ValidatorTest {
	private Validator validator;
	
	@BeforeEach
	void setUp() {
		validator = ValidatorImpl.getInstance();
	}
	
	@Test
	@DisplayName("성공: 문자열이 숫자로만 이루어져있는지 검증")
	void assertIsNumber_Valid() {
		String input = "12345";
		assertDoesNotThrow(() -> validator.assertIsNumber(input));
	}

	@Test
	@DisplayName("실패: 문자열이 숫자로만 이루어져있는지 검증")
	void assertIsNumber_Invalid() {
		String input = "1a23";
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertIsNumber(input));
		assertEquals(IS_NOT_NUMBER, e.getMessage());
	}
	
	@Test
	@DisplayName("성공: 구매 가격이 " + LOTTO_PRICE + "으로 나누어 떨어지는지 검증")
	void assertIsMultipleOfThousand_Valid() {
		long purchaseAmount = 5000;
		assertDoesNotThrow(() -> validator.assertIsMultipleOfThousand(purchaseAmount));
	}
	
	@Test
	@DisplayName("실패: 구매 가격이 " + LOTTO_PRICE + "으로 나누어 떨어지는지 검증")
	void assertIsMultipleOfThousand_InValid() {
		long purchaseAmount = 5500;
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertIsMultipleOfThousand(purchaseAmount));
		assertEquals(IS_NOT_MULTIPLE_OF_THOUSAND, e.getMessage());
		
	}
	
	@Test
	@DisplayName("성공: 문자열에 " + SEPARATOR + "가 존재하는지 검증")
	void assertContainsSeparator_Valid() {
		String input = "1,2,3,4,5";
		assertDoesNotThrow(() -> validator.assertContainsSeparator(input));
	}
	
	@Test
	@DisplayName("실패: 문자열에 " + SEPARATOR + "가 존재하는지 검증")
	void assertContainsSeparator_Invalid() {
		String input = "1 2 3 4 5";
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertContainsSeparator(input));
		assertEquals(CANNOT_SPLIT_BY_SEPARATOR, e.getMessage());
	}
	
	@Test
	@DisplayName("성공: 당첨 번호 문자열 배열의 크기가 " + NUMBER_COUNT + "인지 검증")
	void assertWinningNumbersCount_Valid() {
		String[] inputSplits = {"100", "200", "300", "400", "500", "600"};
		assertDoesNotThrow(() -> validator.assertWinningNumbersCount(inputSplits));
	}
	
	@Test
	@DisplayName("실패: 당첨 번호 문자열 배열의 크기가 " + NUMBER_COUNT + "인지 검증")
	void assertWinningNumbersCount_Invalid() {
		String[] inputSplits = {"100", "200", "300", "400", "500"};
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertWinningNumbersCount(inputSplits));
		assertEquals(INVALID_WINNING_NUMBERS_COUNT, e.getMessage());
	}
	
	@Test
	@DisplayName("성공: 당첨 번호들 중 중복되는 숫자가 존재하지 않는지 검증")
	void assertUniqueWinningNumbers_Unique() {
		Set<Integer> winningNumberSet = new HashSet<>(List.of(1, 2, 3));
		int number = 4;
		assertDoesNotThrow(() -> validator.assertUniqueWinningNumbers(number, winningNumberSet));
	}
	
	@Test
	@DisplayName("실패: 당첨 번호들 중 중복되는 숫자가 존재하지 않는지 검증")
	void assertUniqueWinningNumbers_Duplicate() {
		Set<Integer> winningNumberSet = new HashSet<>(List.of(1, 2, 3));
		int number = 3;
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertUniqueWinningNumbers(number, winningNumberSet));
		assertEquals(DUPLICATED_NUMBERS, e.getMessage());
	}
	
	@Test
	@DisplayName("성공: 로또 번호가 " + START_NUMBER + "부터 " + END_NUMBER + " 사이의 숫자인지 검증")
	void assertRange_Valid() {
		int number = 10;
		assertDoesNotThrow(() -> validator.assertRange(number));
	}
	
	@Test
	@DisplayName("실패: 로또 번호가 " + START_NUMBER + "부터 " + END_NUMBER + " 사이의 숫자인지 검증")
	void assertRange_Invalid() {
		int number = 50;
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertRange(number));
		assertEquals(INVALID_RANGE, e.getMessage());
	}
	
	@Test
	@DisplayName("성공: 보너스 번호와 같은 숫자가 당첨 번호에 존재하지 않는지 검증")
	void assertBonusNotInWinningNumbers_NotIn() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		assertDoesNotThrow(() -> validator.assertBonusNotInWinningNumbers(bonusNumber, winningNumbers));	
	}
	
	@Test
	@DisplayName("실패: 보너스 번호와 같은 숫자가 당첨 번호에 존재하지 않는지 검증")
	void assertBonusNotInWinningNumbers_In() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 6;
		IllegalArgumentException e
			= assertThrows(IllegalArgumentException.class, () -> validator.assertBonusNotInWinningNumbers(bonusNumber, winningNumbers));
		assertEquals(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER, e.getMessage());
	}
}
