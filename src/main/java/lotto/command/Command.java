package lotto.command;

import lotto.dto.UserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public interface Command<U, T> {
  UserInput execute(T parameter);
}
