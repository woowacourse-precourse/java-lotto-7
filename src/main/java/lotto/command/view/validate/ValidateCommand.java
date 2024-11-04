package lotto.command.view.validate;

import lotto.common.exception.ExceptionEnum;
import lotto.command.Command;
import lotto.dto.UserInput;
import lotto.view.ConsoleView;
import lotto.view.View;
import lotto.view.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public abstract interface ValidateCommand extends Command<UserInput, String> {
  View view = new ConsoleView();
  String ask();

  default UserInput redo () {
    return (UserInput) view.promptInput(this);
  }

  default void validateBlank(String input) {
    if (input.isBlank()){
      throw new InputException(ExceptionEnum.CONTAIN_BLANK);
    }
  }

  default void validateWhiteSpace(String input) {
    if (hasWhiteSpace(input)) {
      throw new InputException(ExceptionEnum.CONTAIN_WHITESPACE);
    }
  }

  default boolean hasWhiteSpace(String input) {
    return input.chars()
        .anyMatch(Character::isWhitespace);
  }

  default int validateIntegerRange(String input, int minimum, int maximum) {
    try {
      int value = Integer.parseInt(input);
      validateMinimum(value, minimum);
      validateMaximum(value, maximum);
      return value;
    } catch (NumberFormatException e) {
      String runtimeMessage = String.format("%d ~ %d", minimum, maximum);
      throw new InputException(ExceptionEnum.INVALID_INTEGER_RANGE,
          runtimeMessage);
    }
  }

  default void validateMinimum(int value, int minimum) {
    if (value < minimum) {
      String runtimeMessage = String.valueOf(minimum);
      throw new InputException(ExceptionEnum.INPUT_LESS_THAN_MINIMUM,
          runtimeMessage);
    }
  }

  default void validateMaximum(int value, int maximum) {
    if (value > maximum) {
      String runtimeMessage = String.valueOf(maximum);
      throw new InputException(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM,
          runtimeMessage);
    }
  }

  default long validateLongRange(String input, long minimum, long maximum) {
    try {
      long value = Long.parseLong(input);
      validateMinimum(value, minimum);
      validateMaximum(value, maximum);
      return value;
    } catch (NumberFormatException e) {
      throw new InputException(ExceptionEnum.INVALID_LONG_RANGE);
    }
  }

  default void validateMinimum(long value, long minimum) {
    if (value < minimum) {
      String runtimeMessage = String.valueOf(minimum);
      throw new InputException(ExceptionEnum.INPUT_LESS_THAN_MINIMUM,
          runtimeMessage);
    }
  }

  default void validateMaximum(long value, long maximum) {
    if (value > maximum) {
      String runtimeMessage = String.valueOf(maximum);
      throw new InputException(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM,
          runtimeMessage);
    }
  }
}
