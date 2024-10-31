package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import lotto.validation.*;

public class Input {
    public static int money() throws IllegalArgumentException {
        return InputValid.checkMoney(Console.readLine());
    }

    public static void number() {

    }

    public static int bonus() {
        return InputValid.checkEachNum(Console.readLine());
    }
}
