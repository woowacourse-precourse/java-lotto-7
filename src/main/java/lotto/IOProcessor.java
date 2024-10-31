package lotto;

import static lotto.ExceptionHandler.validateNumeric;
import static lotto.Utils.parseByComma;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    public static List<String> getCommaSeperatedText(String guide) {
        System.out.println(guide);
        String commaSeperatedText = Console.readLine().strip();
        return parseByComma(commaSeperatedText);
    }
}