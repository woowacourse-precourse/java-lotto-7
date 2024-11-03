package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static BigDecimal readPurchaseAmount() {
        String purchaseAmount = readLine();
        return new BigDecimal(purchaseAmount);
    }

    public static List<Integer> readLottoNumbers() {
        String lottoNumbers = readLine();
        return Arrays.stream(lottoNumbers.split(","))
                     .map(Integer::parseInt)
                     .toList();
    }

    public static int readBonusNumber() {
        String bonusNumber = readLine();
        return parseInt(bonusNumber);
    }
}
