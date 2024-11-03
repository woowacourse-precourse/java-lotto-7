package lotto.parser;

import static lotto.model.Constants.MULTIPLES_OF_LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InputException;
import lotto.message.ErrorMessage;
import lotto.model.WinningLotto;
import lotto.validator.InputValidator;

public class InputParser {

    /**
     * 구매 금액을 구매 수량으로 파싱
     */
    public static int parsePurchaseAmount(String input) {
        int purchaseAmount;
        InputValidator.isPurchaseAmountBlank(input);

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_TYPE_PURCHASE_AMOUNT.getMessage());
        }

        InputValidator.isMultiplesOfThousand(purchaseAmount);

        return purchaseAmount / MULTIPLES_OF_LOTTO_PRICE;
    }

    /**
     * 당첨번호(String)를 WinningLotto 로 파싱
     */
    public static WinningLotto parseWinningLotto(String winningNumbers, int bonusNumber) {
        InputValidator.isWinningNumbersBlank(winningNumbers);

        try{
            List<Integer> winningNumberList = Arrays.stream(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            InputValidator.hasDuplicateNumbers(winningNumberList);
            winningNumberList.forEach(InputValidator::isWinningNumbersRangeIn);
            InputValidator.hasDuplicateBonusNumber(winningNumberList, bonusNumber);

            return new WinningLotto(winningNumberList, bonusNumber);

        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }
}
