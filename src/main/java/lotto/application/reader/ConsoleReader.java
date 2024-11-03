package lotto.application.reader;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.Reader;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        return Console.readLine();
    }
}
