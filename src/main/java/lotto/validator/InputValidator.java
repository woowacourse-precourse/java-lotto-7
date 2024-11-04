package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.LottoConstants;

public class InputValidator implements InputValidatorInterface{

  public int validatePurchaseAmount(String amount) {
    int purchaseAmount;
    try {
      purchaseAmount = Integer.parseInt(amount);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
    }

    if (purchaseAmount <= 0 || purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }
    return purchaseAmount;
  }

  public List<Integer> validateWinningNumbers(String winningNumbers) {
    List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    if (numbers.size() != LottoConstants.NUMBER_COUNT || hasInvalidRange(numbers)) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자 6개여야 합니다.");
    }
    return numbers;
  }

  public int validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
    int parsedBonusNumber;
    try {
      parsedBonusNumber = Integer.parseInt(bonusNumber);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }
    if (parsedBonusNumber < LottoConstants.MIN_NUMBER || parsedBonusNumber > LottoConstants.MAX_NUMBER || winningNumbers.contains(parsedBonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자 중 당첨 번호와 중복되지 않는 숫자여야 합니다.");
    }
    return parsedBonusNumber;
  }

  private static boolean hasInvalidRange(List<Integer> numbers) {
    return numbers.stream().anyMatch(num -> num < LottoConstants.MIN_NUMBER || num > LottoConstants.MAX_NUMBER);
  }
}
