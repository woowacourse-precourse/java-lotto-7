package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

import static lotto.util.BonusNumberValidation.validateBonusNumber;
import static lotto.util.WinningLottoNumberValidation.validateWinningNumbers;
import static lotto.util.PurchaseAmountValidation.ValidatePurchaseAmount;

import java.util.Arrays;
import java.util.List;


public class InputView {
    public static int readPurchasePrice() {
        String purchasePrice = Console.readLine();
        ValidatePurchaseAmount(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    public static List<Integer> readWinningNumbers() {
        String lottoNumbers = Console.readLine();
        validateWinningNumbers(lottoNumbers);
        return Arrays.stream(lottoNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public static int readBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

}
