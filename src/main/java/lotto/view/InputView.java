package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER_IS_NOT_ALLOWED;
import static lotto.exception.ErrorMessage.EMPTY_INPUT_IS_NOT_POSSIBLE;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_FORMAT;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.exception.ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT;

public class InputView {
    public int getPurchaseAmount() {
        int purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");

        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        String winningString;
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        winningString = Console.readLine();

        if (winningString.isEmpty()) {
            throw new InvalidWinningNumbersException(EMPTY_INPUT_IS_NOT_POSSIBLE.getMessage());
        }

        if (!winningString.matches("^\\d+(,\\d+){5}")) {
            throw new InvalidWinningNumbersException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }

        return createLottoWithWinningNumbers(winningString);
    }

    private List<Integer> createLottoWithWinningNumbers(String winningString) {
        List<String> splitWinningString = List.of(winningString.split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        for (String string : splitWinningString) {
            int number = Integer.parseInt(string);

            if (number < 1 || number > 45) {
                throw new InvalidWinningNumbersException(INVALID_NUMBER_RANGE.getMessage());
            }

            if (!uniqueNumbers.add(number)) {
                throw new InvalidWinningNumbersException(DUPLICATE_NUMBER_IS_NOT_ALLOWED.getMessage());
            }

            winningNumbers.add(number);
        }

        return winningNumbers;
    }
}
