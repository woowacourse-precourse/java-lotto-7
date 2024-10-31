package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    private static String COMMA_DELIMITER = ",";

    public static String readLine() {
        return Console.readLine();
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER)).toList();
    }
}
