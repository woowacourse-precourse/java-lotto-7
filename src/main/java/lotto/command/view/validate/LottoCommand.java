package lotto.command.view.validate;

import static lotto.service.lotto.constant.LottoConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.service.lotto.constant.LottoConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.service.lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.view.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class LottoCommand implements ValidateCommand {
  private static final String DELIMITER = ",";
  private static final String ASK = "\n당첨 번호를 입력해 주세요.";

  @Override
  public UserInput execute(String input) {
    try {
      return validate(input);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.displayOutput(e.getMessage());
      return redo();
    }
  }

  public WinningLottoUserInput validate(String input) {
    validateBlank(input);
    validateWhiteSpace(input);
    String[] rawNumbers = input.split(DELIMITER);
    return WinningLottoUserInput.from(validateNumbers(rawNumbers));
  }

  private List<Integer> validateNumbers(String[] rawNumbers) {
    List<Integer> lottoNumbers = validateLottoNumbers(rawNumbers);
    validateDistinct(lottoNumbers);
    validateCount(lottoNumbers);
    return lottoNumbers;
  }

  private List<Integer> validateLottoNumbers(String[] rawNumbers) {
    List<Integer> numbers = new ArrayList<>();
    for (String rawNumber : rawNumbers) {
      int value = validateIntegerRange(rawNumber, LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER);
      numbers.add(value);
    }
    return numbers;
  }

  private void validateDistinct(List<Integer> lottoNumbers) {
    long distinctCount = lottoNumbers.stream()
        .distinct()
        .count();
    if (distinctCount != lottoNumbers.size()) {
      throw new InputException(ExceptionEnum.LOTTO_NUMBER_NOT_DISTINCT);
    }
  }

  private void validateCount(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new InputException(ExceptionEnum.LOTTO_NUMBER_COUNT_NOT_AVAILABLE,
          String.valueOf(lottoNumbers.size()));
    }
  }

  @Override
  public String ask() {
    return ASK;
  }
}
