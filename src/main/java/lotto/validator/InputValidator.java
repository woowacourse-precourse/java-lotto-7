package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.LottoConstants;
import lotto.constants.LottoErrorMessages;

public class InputValidator implements InputValidatorInterface{

  public int validatePurchaseAmount(String amount) {
    int purchaseAmount;
    try {
      purchaseAmount = Integer.parseInt(amount);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(LottoErrorMessages.INVALID_NUMBER_FORMAT);
    }

    if (purchaseAmount <= 0 || purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(LottoErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT);
    }
    return purchaseAmount;
  }

  public List<Integer> validateWinningNumbers(String winningNumbers) {
    List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    if (numbers.size() != LottoConstants.NUMBER_COUNT || hasInvalidRange(numbers)) {
      throw new IllegalArgumentException(LottoErrorMessages.INVALID_WINNING_NUMBER_RANGE);
    }
    return numbers;
  }

  public int validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
    int parsedBonusNumber;
    try {
      parsedBonusNumber = Integer.parseInt(bonusNumber);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(LottoErrorMessages.INVALID_BONUS_NUMBER_FORMAT);
    }
    if (parsedBonusNumber < LottoConstants.MIN_NUMBER || parsedBonusNumber > LottoConstants.MAX_NUMBER || winningNumbers.contains(parsedBonusNumber)) {
      throw new IllegalArgumentException(LottoErrorMessages.INVALID_BONUS_NUMBER_RANGE);
    }
    return parsedBonusNumber;
  }

  private static boolean hasInvalidRange(List<Integer> numbers) {
    return numbers.stream().anyMatch(num -> num < LottoConstants.MIN_NUMBER || num > LottoConstants.MAX_NUMBER);
  }
}
