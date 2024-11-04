package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public static String inputPurchasingMoney() {
        return Console.readLine();
    }

    public static List<String> inputDefaultLottoNumbers() {
        return new ArrayList<>(
            Arrays.asList(Console.readLine().split(DELIMITER)));
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
