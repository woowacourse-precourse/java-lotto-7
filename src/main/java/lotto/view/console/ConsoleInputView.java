package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputConvertor;
import lotto.view.InputView;

public class ConsoleInputView implements InputView {

    private static final String DELIMITER_COMMA = ",";

    @Override
    public int readNumber() {
        final String input = readInput();
        return InputConvertor.parseToInt(input.trim());
    }

    @Override
    public List<Integer> readNumbers() {
        final String input = readInput();
        return InputConvertor.parseToNumbers(DELIMITER_COMMA, input.trim());
    }

    private String readInput() {
        return Console.readLine();
    }
}
