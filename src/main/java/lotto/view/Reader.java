package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    private Reader() {}

    public static Reader initiate() {
        return new Reader();
    }

    public String readInput() {
        return Console.readLine();
    }
}
