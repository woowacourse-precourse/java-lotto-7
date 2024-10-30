package lotto;

import static lotto.ExceptionHandler.validateNumeric;

import camp.nextstep.edu.missionutils.Console;

public class IOProcessor {
    public static int getNumber(String guide) {
        System.out.println(guide);
        String numberText = Console.readLine().strip();

        try {
            validateNumeric(numberText);
        } catch (IllegalArgumentException e) {
            getNumber(guide);
        }
        return Integer.parseInt(numberText);
    }
}