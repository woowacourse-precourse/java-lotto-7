package lotto.command.view.validate;

import static lotto.service.lotto.constant.LottoConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.service.lotto.constant.LottoConstant.LOTTO_MINIMUM_NUMBER;

import lotto.common.exception.ExceptionEnum;
import lotto.dto.BonusUserInput;
import lotto.dto.UserInput;
import lotto.model.lotto.WinningLotto;
import lotto.view.exception.InputException;


/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class BonusCommand implements ValidateCommand {
  private static final String ASK = "\n보너스 번호를 입력해 주세요.";
  private WinningLotto winningLotto;

  private BonusCommand(WinningLotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public static BonusCommand from(WinningLotto winningLotto) {
    return new BonusCommand(winningLotto);
  }

  @Override
  public UserInput execute(String input) {
    try {
      return validate(input);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.displayOutput(e.getMessage());
      return redo();
    }
  }

  public BonusUserInput validate(String input) {
    validateBlank(input);
    validateWhiteSpace(input);
    int number = validateIntegerRange(input, LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER);
    validateDistinctWithWinningLotto(number);
    return BonusUserInput.from(number);
  }

  private void validateDistinctWithWinningLotto(int number) {
    if (winningLotto.getNumbers().contains(number)) {
      throw new InputException(ExceptionEnum.BONUS_NUMBER_NOT_DISTICT);
    }
  }

  @Override
  public String ask() {
    return ASK;
  }
}
