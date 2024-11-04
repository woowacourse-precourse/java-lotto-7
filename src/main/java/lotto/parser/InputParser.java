package lotto.parser;

import static lotto.constant.Constants.DELIMITER;
import static lotto.constant.Constants.LOTTO_PRICE;

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

        return purchaseAmount / LOTTO_PRICE;
    }

    /**
     * 당첨 번호 List 형식으로 파싱
     */
    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        InputValidator.isWinningNumbersBlank(winningNumbers);

        try {
            List<Integer> winningNumberList = Arrays.stream(winningNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            InputValidator.hasDuplicateNumbers(winningNumberList);
            winningNumberList.forEach(InputValidator::isLottoNumbersRangeIn);

            return winningNumberList;
        } catch(NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_LOTTO_NUMBERS.getMessage());
        }
    }

    /**
     * 보너스 번호 파싱
     */
    public static int parseBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        try {
            InputValidator.isBonusNumberBlank(bonusNumber);
            int newBonusNumber = Integer.parseInt(bonusNumber);
            InputValidator.hasDuplicateBonusNumber(winningNumbers, newBonusNumber);

            return newBonusNumber;
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_TYPE_BONUS_NUMBER.getMessage());
        }
    }

    /**
     * 당첨번호(String)를 WinningLotto 로 파싱
     */
    public static WinningLotto parseWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        try{
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessage.UNAVAILABLE_LOTTO_NUMBERS.getMessage());
        }
    }
}
