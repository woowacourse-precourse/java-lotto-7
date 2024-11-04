package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.command.Command;
import lotto.command.view.validate.ValidateCommand;
import lotto.dto.UserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class ConsoleView implements View {

  @Override
  public UserInput promptInput(ValidateCommand command) {
    writeLine(command.ask());
    String input = readLine();
    return command.execute(input);
  }

  @Override
  public void displayOutput(Object parameter) {
    writeLine(parameter.toString());
  }

  private void writeLine(String text) {
    System.out.println(text);
  }

  private String readLine() {
    return Console.readLine();
  }
}
