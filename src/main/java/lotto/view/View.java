package lotto.view;

import lotto.command.validate.ValidateCommand;
import lotto.dto.UserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public interface View {
  UserInput promptInput(ValidateCommand command);
}
