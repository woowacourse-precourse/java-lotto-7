package lotto.io;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validation.InputValid;

public class Input {
    public static int money() throws IllegalArgumentException {
        return InputValid.checkMoney(Console.readLine());
    }

    public static Lotto number() throws IllegalArgumentException {
        return InputValid.checkNumber(Console.readLine());
    }

    public static int bonus() throws IllegalArgumentException {
        return InputValid.checkEachNum(Console.readLine());
    }
}
