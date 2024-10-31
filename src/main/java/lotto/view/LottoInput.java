package lotto.view;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.List;

public class LottoInput {
    public static int inputCost() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static List<String> inputCorrectNumbers() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
