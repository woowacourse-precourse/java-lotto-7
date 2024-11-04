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

	private static int validateLottoPurchaseAmountFormat(String lottoPurchaseAmount) {
		try {
			return Integer.parseInt(lottoPurchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입 금액이 잘못된 형식입니다.");
		}
	}

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
		validateLottoNumber(bonusNumber);
		return bonusNumber;
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

	private static void validateLottoNumber(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "에서 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
		}
	}
}
