package lotto.io;

import static lotto.exception.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String ANSWER_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_LOTTO_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;

	private static int validateLottoPurchaseAmountFormat(String lottoPurchaseAmount) {
		try {
			return Integer.parseInt(lottoPurchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입 금액이 잘못된 형식입니다.");
		}
	}

	public static int readPurchaseAmount() {
		while (true) {
			try {
				System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
				return validateLottoPurchaseAmountFormat(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static List<Integer> readAnswerLotto() {
		while (true) {
			try {
				System.out.println(ANSWER_LOTTO_INPUT_MESSAGE);
				String input = Console.readLine();
				List<Integer> answerLottoNumbers = parseLottoNumbers(input);
				validateLottoNumbers(answerLottoNumbers);
				return answerLottoNumbers;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int readBonusLotto() {
		while (true) {
			try {
				System.out.println(BONUS_LOTTO_INPUT_MESSAGE);
				int bonusNumber = Integer.parseInt(Console.readLine());
				validateLottoNumber(bonusNumber);
				return bonusNumber;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 보너스 번호가 잘못된 형식입니다.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static List<Integer> parseLottoNumbers(String input) {
		try {
			return Arrays.stream(input.split(","))
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 올바른 숫자 형식이어야 합니다.");
		}
	}

	private static void validateLottoNumbers(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LOTTO_NUMBER_COUNT + "개의 숫자여야 합니다.");
		}
		if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + MIN_LOTTO_NUMBER + "에서 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
		}
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
		}
	}

	private static void validateLottoNumber(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "에서 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
		}
	}
}
