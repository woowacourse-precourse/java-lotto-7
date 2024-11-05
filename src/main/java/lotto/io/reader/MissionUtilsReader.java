package lotto.io.reader;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.IllegalInputReadException;

public class MissionUtilsReader implements Reader {

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalInputReadException();
        }
    }
}
