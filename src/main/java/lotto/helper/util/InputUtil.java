package lotto.helper.util;

import java.util.Arrays;
import java.util.List;
import lotto.helper.valid.ValidInput;

public class InputUtil {

    public static int parseMoney(String inputMoney) {
        ValidInput.checkInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> splitNumbers(String inputNumbers) {
        ValidInput.checkInputLottoNumbers(inputNumbers);
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseBonusNumber(String inputBonusNumber) {
        ValidInput.checkInputBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }
}
