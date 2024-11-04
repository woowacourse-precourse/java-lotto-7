package lotto.parser;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.validator.Validator;
import lotto.validator.ValidatorImpl;

import static lotto.constant.Regex.*;

public class ParserImpl implements Parser {
	private static final Parser INSTANCE;
	private final Validator validator;
	
	static {
		INSTANCE = new ParserImpl(ValidatorImpl.getInstance());
	}
	
	private ParserImpl(final Validator validator) {
		this.validator = validator;
	}
	
	public static Parser getInstance() {
		return INSTANCE;
	}
	
	@Override
	// 구매 금액 입력 문자열 파싱
	public BigInteger purchaseAmount(final String input) {
		return getValidatedPurchaseAmount(input);
	}
	
	@Override
	// 당첨 번호 입력 문자열 파싱
	public List<Integer> winningNumbers(final String input) {
		return getValidatedWinningNumbers(input);
	}
	
	@Override
	// 보너스 번호 입력 문자열 파싱
	public int bonusNumber(final String input, final List<Integer> winningNumbers) {
		return getValidatedBonusNumber(input, winningNumbers);
	}
	
	// 구매 금액 검증 후 BigInteger로 파싱하여 리턴
	private BigInteger getValidatedPurchaseAmount(final String input) {
		validator.assertIsNumber(input);
		
		long purchaseAmount = Long.parseLong(input);
		validator.assertIsMultipleOfThousand(purchaseAmount);
		
		return BigInteger.valueOf(purchaseAmount);
	}
	
	// 당첨 번호 입력값 문자열 검증 후 정수 리스트로 변환하여 리턴
	private List<Integer> getValidatedWinningNumbers(final String input) {
		validator.assertContainsSeparator(input);
		
		String[] inputSplits = input.split(SEPARATOR);
		validator.assertWinningNumbersCount(inputSplits);
		
		return getValidatedIntegerList(inputSplits);
	}
	
	// 당첨 번호 문자열 배열 모두 검증 후 정수 리스트로 변환하여 리턴
	private List<Integer> getValidatedIntegerList(final String[] inputSplits) {
		Set<Integer> winningNumberSet = new HashSet<>();
		
		return Arrays.stream(inputSplits)
					 .map(inputSplit -> getValidatedNumber(inputSplit, winningNumberSet))
					 .collect(Collectors.toList());
	}
	
	// 당첨 번호 1개 검증 후 정수로 변환하여 리턴
	private int getValidatedNumber(final String inputSplit, final Set<Integer> winningNumberSet) {
		validator.assertIsNumber(inputSplit);
		
		int number = Integer.parseInt(inputSplit);
		validator.assertRange(number);
		
		validator.assertUniqueWinningNumbers(number, winningNumberSet);
		
		return number;
	}
	
	// 보너스 번호 검증 후 정수로 변환하여 리턴
	private int getValidatedBonusNumber(final String input, final List<Integer> winningNumbers) {
		validator.assertIsNumber(input);
		
		int bonusNumber = Integer.parseInt(input);
		validator.assertRange(bonusNumber);
		
		validator.assertBonusNotInWinningNumbers(bonusNumber, winningNumbers);
		
		return bonusNumber;
	}
}
