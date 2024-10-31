package lotto;

import static lotto.ExceptionHandler.validateNumeric;
import static lotto.Utils.parseByComma;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOProcessor {
    public static int readNumber(String guide) {
        String numberText = "";
        while (true) {
            try {
                System.out.println(guide);
                numberText = Console.readLine().strip();
                validateNumeric(numberText);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(numberText);
    }

    public static List<String> readCommaSeperatedText(String guide) {
        System.out.println(guide);
        String commaSeperatedText = Console.readLine().strip();
        return parseByComma(commaSeperatedText);
    }
}