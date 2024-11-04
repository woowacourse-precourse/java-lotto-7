package lotto.io;

import static lotto.exception.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String ANSWER_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_LOTTO_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	public static int readPurchaseAmount() {
		System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
		return validateLottoPurchaseAmountFormat(Console.readLine());
	}

	public static Lotto readAnswerLotto() {
		System.out.println(ANSWER_LOTTO_INPUT_MESSAGE);
		String input = Console.readLine();
		List<Integer> answerLottos = parseLottoNumbers(input);
		return new Lotto(answerLottos);
	}

	public static int readBonusLotto() {
		System.out.println(BONUS_LOTTO_INPUT_MESSAGE);
		int bonusNumber =  validateLottoPurchaseAmountFormat(Console.readLine());
		validateLottoNumberRange(bonusNumber);
		return bonusNumber;
	}

	private static List<Integer> parseLottoNumbers(String input) {
			return Arrays.stream(input.split(","))
				.map((number) -> validateLottoPurchaseAmountFormat(number))
				.map(Input::validateLottoNumberRange)
				.collect(Collectors.toList());
	}

	private static int validateLottoPurchaseAmountFormat(String lottoPurchaseAmount) {
		try {
			return Integer.parseInt(lottoPurchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT_INPUT.getMessage());
		}
	}

	private static int validateLottoNumberRange(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
		}
		return number;
	}
}
