package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public void read() {
        Console.readLine();
    }
}
