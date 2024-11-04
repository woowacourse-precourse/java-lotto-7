package lotto.view;

import lotto.command.view.validate.ValidateCommand;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public interface View<T, P> {
  T promptInput(ValidateCommand command);
  void displayOutput(P parameter);
}
