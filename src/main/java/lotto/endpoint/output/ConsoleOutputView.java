package lotto.endpoint.output;

import lotto.common.Displayable;

public class ConsoleOutputView implements OutputView {
    private static final String ERROR="[ERROR] ";
    @Override
    public void printLine(Displayable line) {
        System.out.println(line.toPrettyString());
    }

    @Override
    public void printWithArgs(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    @Override
    public void printError(String message) {
        System.out.println(ERROR+message);
    }
}
