package lotto.view;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.List;

public class LottoInput {
    public static String inputCost() {
        return Console.readLine();
    }

    public static List<String> inputCorrectNumbers() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
