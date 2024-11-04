package lotto.endpoint.output;

import lotto.common.Displayable;

public interface OutputView {
    void printLine(Displayable line);
    void printWithArgs(String format, Object... args);
    void printError(String message);
}
