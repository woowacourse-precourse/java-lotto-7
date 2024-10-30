package lotto.command;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public interface Command<T> {
  void execute(T parameter);
}
