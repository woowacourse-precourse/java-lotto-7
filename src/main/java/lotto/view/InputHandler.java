package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.MoneyInputErrorMessage;
import lotto.dto.LottoDto;

import java.util.List;
import java.util.stream.Stream;

import static lotto.Constants.*;

public class InputHandler {

    public long inputLottoPurchaseMoney() {
        String lottoPurchaseMoney = promptInput(LOTTO_PURCHASE_MONEY_PROMPT);
        return parseMoney(lottoPurchaseMoney);
    }

    public LottoDto inputWinningNumbers() {
        String winningNumbers = promptInput(WINNING_NUMBER_PROMPT);
        List<Integer> numbers = Stream.of(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new LottoDto(numbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = promptInput(BONUS_NUMBER_PROMPT);
        return Integer.parseInt(bonusNumber);
    }

    private String promptInput(String message) {
        System.out.printf(message);
        return Console.readLine();
    }

    private long parseMoney(String inputAmount) {
        try {
            inputAmount = inputAmount.trim();

            if (inputAmount.length() >= String.valueOf(LOTTO_PRICE * MAX_PURCHASABLE_LOTTOS).length()) {
                throw new IllegalArgumentException(MoneyInputErrorMessage.INVALID_AMOUNT.getMessage());
            }
            return Long.parseLong(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}