package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputPurchasingMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputDefaultLottoNumbers() {
        List<Integer> defaultLottoNumbers = new ArrayList<>();
        defaultLottoNumbers.add(Integer.parseInt(Console.readLine()));
        return defaultLottoNumbers;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
